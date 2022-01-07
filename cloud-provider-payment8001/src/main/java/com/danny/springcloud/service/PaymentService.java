package com.danny.springcloud.service;


import com.danny.springcloud.bean.pojo.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
