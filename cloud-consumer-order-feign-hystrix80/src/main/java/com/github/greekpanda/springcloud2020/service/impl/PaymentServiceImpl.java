package com.github.greekpanda.springcloud2020.service.impl;

import com.github.greekpanda.springcloud2020.service.IPaymentService;
import org.springframework.stereotype.Component;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/24 09:18
 */
@Component
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "PaymentServiceImpl paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "PaymentServiceImpl paymentInfo_TimeOut";
    }
}
