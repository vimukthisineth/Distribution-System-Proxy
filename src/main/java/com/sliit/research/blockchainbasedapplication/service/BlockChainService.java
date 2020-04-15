package com.sliit.research.blockchainbasedapplication.service;

import com.sliit.research.blockchainbasedapplication.blockChain.Block;
import com.sliit.research.blockchainbasedapplication.model.BlockModel;

import java.io.IOException;
import java.util.List;

public interface BlockChainService {
    BlockModel addBlock(Block block) throws IOException;
    List<Block> getBlockChain() throws IOException;
    void getBlockChainFromDb() throws IOException;
}
