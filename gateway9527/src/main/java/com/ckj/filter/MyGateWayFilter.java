package com.ckj.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*****MyGateWayFilter start*****");

        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            log.info("非法用户，filter");
            exchange.getResponse().setRawStatusCode(HttpStatus.SC_NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        log.info("*****MyGateWayFilter end*****");
        return chain.filter(exchange);
    }


    // 加载过滤器的顺序，数字越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
