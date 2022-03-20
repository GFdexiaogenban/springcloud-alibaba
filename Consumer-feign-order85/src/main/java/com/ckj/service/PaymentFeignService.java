package com.ckj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
// @FeignClient(value = "provider-payment") // 调用的微服务名称
public interface PaymentFeignService{
    // @GetMapping(value = "/getPort/{id}")
    // public String getPort(@PathVariable("id") Long id);
    //
    // @GetMapping("/payment/timeout")
    // public String paymentFeignTimeout();
}
