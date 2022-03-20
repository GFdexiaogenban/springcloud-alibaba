package com.ckj.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ckj.entities.CommonResult;
import com.ckj.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderNacosController {
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback")
    @SentinelResource(value = "fallback", fallback = "handlerFallback") //fallback 只负责业务异常
    public CommonResult fallback(@PathVariable Long id) {
        CommonResult result = restTemplate.getForObject(serviceUrl + "/getPaymentAndPort/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常……");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException，该ID没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常handlerFallback,exception内容" + e.getMessage(), payment);
    }


}
