package com.ckj.controller;

import com.ckj.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignOrderNacosController {
    // @Resource
    // private PaymentFeignService paymentFeignService;


    // @GetMapping(value = "/consumer/getPaymentPort/{id}")
    // public String getPaymentById(@PathVariable("id") Long id){
    //     return paymentFeignService.getPort(1L);
    // }
    //
    // @GetMapping("/consumer/payment/timeout")
    // public String paymentTimeout(){
    //     return paymentFeignService.paymentFeignTimeout();
    // }
}
