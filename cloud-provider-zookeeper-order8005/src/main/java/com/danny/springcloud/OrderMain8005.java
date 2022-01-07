package com.danny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//向consul 或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class OrderMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8005.class);
    }
}
