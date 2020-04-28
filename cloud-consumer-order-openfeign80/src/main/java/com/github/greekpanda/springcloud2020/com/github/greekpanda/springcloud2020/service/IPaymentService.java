package com.github.greekpanda.springcloud2020.com.github.greekpanda.springcloud2020.service;

import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 1:41
 */
@Component
@FeignClient(value="cloud-payment-service")
public interface IPaymentService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
