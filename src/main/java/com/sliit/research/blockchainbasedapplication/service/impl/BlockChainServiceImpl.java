package com.sliit.research.blockchainbasedapplication.service.impl;

import com.sliit.research.blockchainbasedapplication.RestClients.BlockChainMicroserviceRestClient;
import com.sliit.research.blockchainbasedapplication.blockChain.Block;
import com.sliit.research.blockchainbasedapplication.blockChain.BlockChain;
import com.sliit.research.blockchainbasedapplication.model.BlockModel;
import com.sliit.research.blockchainbasedapplication.service.BlockChainService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("blockChainService")
public class BlockChainServiceImpl implements BlockChainService {

    BlockChainMicroserviceRestClient blockChainMicroserviceRestClient = new BlockChainMicroserviceRestClient();

    @Override
    public BlockModel addBlock(Block block) throws IOException {
        BlockModel blockModel = new BlockModel(block);
        blockModel = blockChainMicroserviceRestClient.newBlock(blockModel);
        return blockModel;
    }

    @Override
    public List<Block> getBlockChain() throws IOException {
        return blockChainMicroserviceRestClient.getAllBlocksFromDb();
    }

    @Override
    public void getBlockChainFromDb() throws IOException {
        BlockChain blockChain = BlockChain.getInstance();
        if (!blockChain.blockChainRestored){
            List<Block> blocks = getBlockChain();
            blockChain.setBlockChain(new ArrayList<>());
            for (Block block : blocks){
                blockChain.addBlock(block);
            }
            blockChain.blockChainRestored = true;
        }
    }
}
