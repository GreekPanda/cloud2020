package com.github.greekpanda.cloudalibaba2020.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/25 08:13
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id) {
        return "hello from nacos " + port + " id " + id;
    }
}
