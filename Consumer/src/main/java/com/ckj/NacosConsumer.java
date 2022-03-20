package com.ckj;

import com.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)
public class NacosConsumer {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer.class,args);
    }
}
