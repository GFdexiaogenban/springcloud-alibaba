package com.ckj.controller;

import com.ckj.service.TestProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    TestProviderClient testProviderClient;

    @GetMapping(value = "/getPort/{id}")
    public String getPortPort(@PathVariable("id") Long id){
        return testProviderClient.getPort(id);
    }
}
