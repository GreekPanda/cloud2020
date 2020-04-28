package com.github.greekpanda.springcloud2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 12:44
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain10001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain10001.class, args);
    }
}
