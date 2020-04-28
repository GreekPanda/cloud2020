package com.github.greekpanda.springcloud2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 2:36
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain10002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain10002.class, args);
    }
}
