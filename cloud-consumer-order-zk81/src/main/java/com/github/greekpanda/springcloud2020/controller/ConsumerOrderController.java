package com.github.greekpanda.springcloud2020.controller;

import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 12:23
 */
@RestController
public class ConsumerOrderController {

    //    private static final String BASE_URL = "http://localhost:8001";

    // 向eureka注册中心去调服务
    private static final String BASE_URL = "http://cloud-payment-zookpeer-service";

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerOrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(BASE_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/insert")
    public CommonResult get(Payment payment) {
        return restTemplate.postForObject(BASE_URL + "/payment/insert", payment, CommonResult.class);
    }
}
