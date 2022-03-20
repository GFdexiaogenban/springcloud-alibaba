package com.ckj.controller;

import com.ckj.pojo.Order;
import com.ckj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import java.math.BigDecimal;

@MapperScan("com.ckj.mapper")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create/{userId}/{productId}/{count}")
    public Boolean create(@PathVariable(value = "userId") long userId, @PathVariable(value = "productId") long productId, @PathVariable(value = "count") int count){
        Order order = new Order();
        order.setCount(count);
        order.setMoney(BigDecimal.valueOf(88));
        order.setProductId(productId);
        order.setUserId(userId);
        order.setStatus(0);
        log.info(order.toString());
        return orderService.create(order);
    }
}
