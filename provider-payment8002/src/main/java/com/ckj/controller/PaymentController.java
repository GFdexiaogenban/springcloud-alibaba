package com.ckj.controller;

import com.ckj.entities.CommonResult;
import com.ckj.entities.Payment;
import com.ckj.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @GetMapping("/payment/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return servicePort;
    }

    @GetMapping(value = "/getPort/{id}")
    public String getPort(@PathVariable("id") Long id) {
        return servicePort + " " + id;
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        }
        return new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查找成功", payment);
        }
        return new CommonResult(444, "查询失败，查询id：" + id, null);
    }

    @GetMapping(value = "/getPaymentAndPort/{id}")
    public CommonResult getPaymentAndPortById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询：" + payment);
        if (payment != null) {
            return new CommonResult(200, servicePort + "查找成功", payment);
        }
        return new CommonResult(444, servicePort + "查询失败，查询id：" + id, null);
    }
}
