package com.ckj.controller;

import com.ckj.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @GetMapping(value = "/getPort/{id}")
    public String getPort(@PathVariable("id") Long id) {
        return paymentService.getPortTTT(id);
    }
}
