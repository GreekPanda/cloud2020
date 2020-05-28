package com.github.greekpanda.cloudalibaba2020.service;

import com.github.greekpanda.springcloud2020.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 16:55
 */
@FeignClient(value = "nacos-provider-payment", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "payment/getById/{id}")
    CommonResult getById(@PathVariable("id") Long id);
}
