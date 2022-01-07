package com.danny.springcloud.controller;

import com.danny.springcloud.bean.vo.PaymentVo;
import com.danny.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import com.danny.springcloud.bean.CommonResult;
import com.danny.springcloud.bean.pojo.Payment;

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
    public CommonResult<PaymentVo> findById(@PathVariable("id") Long id){
        CommonResult<PaymentVo> commonResult = new CommonResult<>();
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询id："+ id + ", 的结果->{}", payment);
        PaymentVo paymentVo = new PaymentVo();
        if(payment != null)
        BeanUtils.copyProperties(payment, paymentVo);
        return commonResult.setData(paymentVo);
    }
}
