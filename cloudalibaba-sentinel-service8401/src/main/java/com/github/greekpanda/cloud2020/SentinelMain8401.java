package com.github.greekpanda.cloud2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 11:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8401.class, args);
    }
}
