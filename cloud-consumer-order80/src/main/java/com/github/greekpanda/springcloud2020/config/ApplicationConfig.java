package com.github.greekpanda.springcloud2020.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by greekpanda on 2020/4/28.
 */
@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced   // 开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
