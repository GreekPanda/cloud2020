package com.github.greekpanda.springcloud2020.controller;

import com.github.greekpanda.springcloud2020.entities.CommonResult;
import com.github.greekpanda.springcloud2020.entities.Payment;
import com.github.greekpanda.springcloud2020.service.IPaymentService;

import lombok.extern.slf4j.Slf4j;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int ret = paymentService.create(payment);
        log.info("Id: " + ret);
        if (ret > 0) {
            return new CommonResult(200, "插入成功", ret);
        } else {
            return new CommonResult(410, "插入失败", ret);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("payment: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(410, "查询失败，没有相应记录: id: " + id, payment);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {

//        List<String> serivce = discoveryClient.getNextServerFromEureka();
//        for(String s : serivce) {
//            log.info("****: + " + s);
//        }

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ii : serviceInstanceList) {
            log.info("host " + ii.getHost() + "\t id" + ii.getInstanceId() + "\t port" + ii.getPort());
        }
        return serviceInstanceList;
    }
}
