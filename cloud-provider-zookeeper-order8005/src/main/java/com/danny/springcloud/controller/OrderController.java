package com.danny.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/zk")
    public String paymentZk(){
        return "springcloud with zookeeper: " + serverPort + "/t" + UUID.randomUUID().toString();
    }
}
