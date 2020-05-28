package com.github.greekpanda.cloudalibaba2020.controller;

import com.github.greekpanda.cloudalibaba2020.service.PaymentService;
import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 16:52
 */
@RestController
public class PaymentController {

    //openfeign实现负载均衡
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/order/{id}", produces = "application/json;charset=UTF-8")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        return paymentService.getById(id);
    }
}
