package com.github.greekpanda.springcloud2020.controller;

import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import com.github.greekpanda.springcloud2020.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;


    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment) {
        int ret = paymentService.create(payment);
        log.info("Id: " + ret);
        if (ret > 0) {
            return new CommonResult(200, "插入成功", ret);
        } else {
            return new CommonResult(410, "插入失败", ret);
        }
    }

    @GetMapping(value="/payment/get/{id}}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("payment: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(410, "查询失败，没有相应记录: id: " + id, payment);
        }
    }
}
