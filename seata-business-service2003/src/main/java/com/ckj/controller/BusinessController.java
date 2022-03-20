package com.ckj.controller;

import com.ckj.service.SeataOrderFeignService;
import com.ckj.service.SeataStorageFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {
    @Autowired
    private SeataOrderFeignService seataOrderFeignService;

    @Autowired
    private SeataStorageFeignService seataStorageFeignService;

    @GetMapping("/buy/{userId}/{productId}/{usedNum}")
    @GlobalTransactional
    public String buy(@PathVariable(value = "userId")  long userId,@PathVariable(value = "productId") long productId,@PathVariable(value = "usedNum") int usedNum){
        seataOrderFeignService.create(userId,productId,usedNum);
        seataStorageFeignService.changeStorage(productId,usedNum);
        return "ok";
    }
}
