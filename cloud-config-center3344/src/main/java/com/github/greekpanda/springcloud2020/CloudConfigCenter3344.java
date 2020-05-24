package com.github.greekpanda.springcloud2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/24 17:14
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344.class, args);
    }
}
