package com.sliit.research.blockchainbasedapplication.RestClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sliit.research.blockchainbasedapplication.blockChain.Block;
import com.sliit.research.blockchainbasedapplication.blockChain.BlockChain;
import com.sliit.research.blockchainbasedapplication.dto.DeliveryRouteDto;
import com.sliit.research.blockchainbasedapplication.model.BlockModel;
import com.sliit.research.blockchainbasedapplication.utils.RoutePath;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BlockChainMicroserviceRestClient extends AbstractRestClient {
    private final String blockChainMicroserviceUrl = "http://localhost:8055/";
    private final String deliveriesMicroserviceUrl = "http://localhost:8032/";

    public BlockModel newBlock(BlockModel blockModel) throws IOException {
        String response = this.post(blockChainMicroserviceUrl+"api/newBlock", mapper.writeValueAsString(blockModel));
        return mapper.readValue(response, BlockModel.class);
    }

    public BlockChain getBlockChain() throws IOException {
        String response = this.get(blockChainMicroserviceUrl+"api/blockChain");
        return mapper.readValue(response, BlockChain.class);
    }

    public List<Block> getAllBlocksFromDb() throws IOException {
        String response = this.get(blockChainMicroserviceUrl+"api/getAllBlocksFromDb");
        return Arrays.asList(mapper.readValue(response, Block[].class));
    }

    public RoutePath calculateRoute(DeliveryRouteDto deliveryRoute) throws IOException {
        String response = this.post(deliveriesMicroserviceUrl+"/calculateRoute", mapper.writeValueAsString(deliveryRoute));
        return mapper.readValue(response, RoutePath.class);
    }
}
