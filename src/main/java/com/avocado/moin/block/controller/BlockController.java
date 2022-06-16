package com.avocado.moin.block.controller;

import com.avocado.moin.block.domain.Block;
import com.avocado.moin.block.service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BlockController {

    private final BlockService blockService;

    @PostMapping("/block")
    public void saveBlock(@RequestBody Block block){
        blockService.addBlock(block);
    }

    @DeleteMapping("/block/{id}")
    public void delBlock(@PathVariable Long id){
        blockService.delBlock(id);
    }
}
