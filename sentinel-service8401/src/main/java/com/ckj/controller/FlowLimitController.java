package com.ckj.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ckj.entities.CommonResult;
import com.ckj.myHandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
        return "testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "testB";
    }

    @GetMapping(value = "/testD")
    @SentinelResource(value = "testD",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult testD() {
        return new CommonResult(200, "自定义内容");
    }

}
