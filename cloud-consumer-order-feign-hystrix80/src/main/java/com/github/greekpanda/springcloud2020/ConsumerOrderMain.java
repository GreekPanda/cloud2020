package com.github.greekpanda.springcloud2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 3:08
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain.class, args);
    }
}
