package com.ckj.controller;

import com.ckj.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/consumer/getPayment/{id}")
    public String getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(serviceUrl+"/payment/get/"+id,String.class);
    }

    @GetMapping(value = "/consumer/getPayment/getForEntity/{id}")
    public CommonResult getInfo(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(serviceUrl+"/payment/get/" + id,CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(String.valueOf(entity.getStatusCode()));
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping(value = "/consumer/getPaymentPort/{id}")
    public String getPaymentPort(@PathVariable("id") Long id){
        return restTemplate.getForObject(serviceUrl+"/getPort/"+id,String.class);
    }

}
