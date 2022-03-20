package com.ckj.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    String getPortTTT(@PathVariable("id") Long id);
}
