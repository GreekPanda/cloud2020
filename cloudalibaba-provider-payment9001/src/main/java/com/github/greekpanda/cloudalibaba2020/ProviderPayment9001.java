package com.github.greekpanda.cloudalibaba2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/25 08:02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9001.class, args);
    }
}
