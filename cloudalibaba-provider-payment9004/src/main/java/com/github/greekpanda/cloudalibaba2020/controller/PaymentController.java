package com.github.greekpanda.cloudalibaba2020.controller;

import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 16:30
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Long, Payment> map = new HashMap<Long, Payment>();

    static {
        map.put(1L, new Payment(1L, "11111"));
        map.put(2L, new Payment(1L, "22222"));
        map.put(3L, new Payment(1L, "33333"));
        map.put(4L, new Payment(1L, "44444"));
    }

    @GetMapping(value = "/payment/getById/{id}", produces = "application/json;charset=UTF-8")
    public CommonResult getById(@PathVariable("id") Long id) {
        if(map.containsKey(id)) {
            return new CommonResult(200, "Success, port=" + serverPort, map.get(id));
        } else {
            return new CommonResult(404, "not existed, port=" + serverPort, null);
        }

    }

}
