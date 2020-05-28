package com.github.greekpanda.cloud2020.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.greekpanda.cloud2020.myHandler.MyHandler;
import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 14:40
 */
@RestController
@Slf4j
public class RateLimitController {
    @GetMapping(value = "/getByResource", produces = "application/json;charset=UTF-8")
    @SentinelResource(value = "getByResource", blockHandler = "dealException")
    public CommonResult getByResource() {
        return new CommonResult(200, "Success", new Payment(10L, "serial1234"));
    }

    public CommonResult dealException() {
        return new CommonResult(450, "Error", new Object());
    }

    @GetMapping(value = "/byUrl", produces = "application/json;charset=UTF-8")
    @SentinelResource(value = "byUrl",
            blockHandlerClass = MyHandler.class,
            blockHandler = "handlerException2")
    public CommonResult byUrl() {
        return new CommonResult(200, "Success", new Payment(10L, "serial3456"));
    }

    //customHandlerController


}
