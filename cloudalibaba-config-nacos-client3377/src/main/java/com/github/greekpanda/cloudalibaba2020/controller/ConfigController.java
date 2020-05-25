package com.github.greekpanda.cloudalibaba2020.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/25 22:12
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${test:hello}")
    private String configInfo;

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return String.valueOf(useLocalCache);
    }
}
