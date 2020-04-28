package com.github.greekpanda.springcloud2020.controller;

import com.github.greekpanda.springcloud2020.com.github.greekpanda.springcloud2020.service.IPaymentService;
import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 1:45
 */
@RestController
@Slf4j
public class OrderOpengFeignController {

    @Resource
    private IPaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        CommonResult<Payment> payment = paymentService.getPaymentById(id);
        log.info("payment: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(410, "查询失败，没有相应记录: id: " + id, payment);
        }
    }
}
