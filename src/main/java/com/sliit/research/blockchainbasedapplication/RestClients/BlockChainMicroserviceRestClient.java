package com.sliit.research.blockchainbasedapplication.RestClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sliit.research.blockchainbasedapplication.blockChain.BlockChain;
import com.sliit.research.blockchainbasedapplication.model.BlockModel;

import java.io.IOException;

public class BlockChainMicroserviceRestClient extends AbstractRestClient {
    private final String blockChainMicroserviceUrl = "http://localhost:8055/";

    public BlockModel newBlock(BlockModel blockModel) throws IOException {
        String response = this.post(blockChainMicroserviceUrl+"api/newBlock", mapper.writeValueAsString(blockModel));
        return mapper.readValue(response, BlockModel.class);
    }

    public BlockChain getBlockChain() throws IOException {
        String response = this.get("api/blockChain");
        return mapper.readValue(response, BlockChain.class);
    }
}
