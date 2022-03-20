package com.ckj.service.impl;

import com.ckj.mapper.OrderMapper;
import com.ckj.pojo.Order;
import com.ckj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public boolean create(Order order) {
        log.info("创建订单开始");
        int index = orderMapper.createNew(order);
        log.info(order.toString());
        log.info("创建订单结束");
        return index > 0;
    }
}
