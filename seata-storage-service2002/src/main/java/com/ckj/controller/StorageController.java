package com.ckj.controller;

import com.ckj.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.ckj.mapper")
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;


    @GetMapping("/storage/change/{productId}/{used}")
    public boolean changeStorage(@PathVariable(value = "productId") long productId,@PathVariable(value = "used") int used){
        return storageService.updateUseNum(productId, used);
    }
}
