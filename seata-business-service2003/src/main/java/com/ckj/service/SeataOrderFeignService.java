package com.ckj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "seata-order-service")
public interface SeataOrderFeignService {

    @GetMapping("/order/create/{userId}/{productId}/{count}")
    public Boolean create(@PathVariable(value = "userId") long userId, @PathVariable(value = "productId") long productId, @PathVariable(value = "count") int count);

}
