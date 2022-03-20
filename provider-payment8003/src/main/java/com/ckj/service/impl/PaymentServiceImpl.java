package com.ckj.service.impl;

import com.ckj.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Value("${server.port}")
    private String servicePort;

    @Override
    public String getPortTTT(Long id) {
        return servicePort + " " + id;
    }
}
