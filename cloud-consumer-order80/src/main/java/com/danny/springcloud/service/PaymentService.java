package com.danny.springcloud.service;

import com.danny.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
