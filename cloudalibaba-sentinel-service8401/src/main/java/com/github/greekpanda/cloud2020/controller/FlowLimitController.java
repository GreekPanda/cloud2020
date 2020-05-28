package com.github.greekpanda.cloud2020.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 11:32
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping(value = "/testA")
    public String testA() {
        return "========testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "========testB";
    }
}
