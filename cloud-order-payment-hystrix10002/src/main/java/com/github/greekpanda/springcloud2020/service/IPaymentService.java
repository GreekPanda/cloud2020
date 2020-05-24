package com.github.greekpanda.springcloud2020.service;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 2:43
 */
public interface IPaymentService {
    String paymentInfo_ok(Long id);

    String paymentInfo_timeout(Long id);

    String paymentI_global_timeout(Long id);

    String paymentCircuitBreaker(Long id);
}
