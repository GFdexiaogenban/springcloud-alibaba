package com.ckj.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProviderTestTest {
    @GetMapping(value = "/getPort/{id}")
    String getPort(@PathVariable("id") Long id);
}
