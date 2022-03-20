package com.ckj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "seata-storage-service") // 调用的微服务名称
public interface SeataStorageFeignService {
    @GetMapping("/storage/change/{productId}/{used}")
    public Boolean changeStorage(@PathVariable(value = "productId") long productId, @PathVariable(value = "used") int used);

}
