package com.danny.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import com.danny.springcloud.bean.CommonResult;
import com.danny.springcloud.bean.pojo.Payment;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    private static final String PAYMENT_BASE_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_BASE_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        log.info(PAYMENT_BASE_URL + "/payment/get/" + id);
        return restTemplate.getForObject(PAYMENT_BASE_URL + "/payment/get/" + id, CommonResult.class);
    }
}
