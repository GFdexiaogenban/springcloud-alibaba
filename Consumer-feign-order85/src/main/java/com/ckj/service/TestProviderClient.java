package com.ckj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "provider-payment")
public interface TestProviderClient extends ProviderTestTest{
}
