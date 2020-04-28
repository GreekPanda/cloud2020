package com.github.greekpanda.springcloud2020.controller;

import com.github.greekpanda.springcloud2020.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 2:42
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id) {
        String result = paymentService.paymentInfo_ok(id);
        log.info("####result :" + result);
        return result;
    }

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id) {
        String result = paymentService.paymentInfo_timeout(id);
        log.info("$$$$$ result :" + result);
        return result;
    }
}
