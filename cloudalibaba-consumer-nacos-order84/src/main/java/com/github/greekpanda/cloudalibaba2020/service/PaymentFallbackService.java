package com.github.greekpanda.cloudalibaba2020.service;

import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 16:57
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult getById(Long id) {
        return new CommonResult(405, "服务器降级", new Payment(id, "错误的记录"));
    }
}
