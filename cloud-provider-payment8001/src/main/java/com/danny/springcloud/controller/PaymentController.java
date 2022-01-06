package com.danny.springcloud.controller;

import com.danny.springcloud.entities.CommonResult;
import com.danny.springcloud.entities.Payment;
import com.danny.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public CommonResult<Object> create(Payment payment){
        CommonResult<Object> commonResult = CommonResult.get();
        int i = paymentService.create(payment);
        log.info("插入结果:" + i);
        if(i <= 0){
            return commonResult.setCode(444).setMessage("调用失败");
        }
        return commonResult.setData(i);
    }
    @GetMapping("/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id){
        CommonResult<Payment> commonResult = new CommonResult<>();
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询id："+ id + ", 的结果->{}", payment);
        return commonResult.setData(payment);
    }
}
