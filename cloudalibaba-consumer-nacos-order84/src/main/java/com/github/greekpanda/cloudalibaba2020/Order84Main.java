package com.github.greekpanda.cloudalibaba2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 16:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Order84Main {
    public static void main(String[] args) {
        SpringApplication.run(Order84Main.class, args);
    }
}
