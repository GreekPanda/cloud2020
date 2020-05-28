package com.github.greekpanda.cloud2020.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("==========testD========");
        return " thread :" + Thread.currentThread().getName() + " testD: ";
    }

    @GetMapping(value = "/testE")
    public String testE() {
        int i = 10 / 0;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("==========testD========");
        return " thread :" + Thread.currentThread().getName() + " testD: ";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {

        return "testHotKey: p1= " + p1 + " p2= " + p2;
    }

    public String dealHotKey(String p1, String p2, BlockException be) {
        return "dealHotKey";
    }

    @GetMapping(value = "/testHotKey1")
    @SentinelResource(value = "testHotKey") //no BlockHandler
    public String testHotKey1(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {

        return "testHotKey: p1= " + p1 + " p2= " + p2;
    }
}
