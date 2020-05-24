package com.github.greekpanda.springcloud2020.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.greekpanda.springcloud2020.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 2:43
 */
@Service
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallBack")
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public String paymentInfo_ok(Long id) {
        String result = "当前线程号: " + Thread.currentThread().getName() + "\t id: " + id + "当前运行正常";
        log.info("运行正常,  " + id);
        return result;
    }

    //设置超时的峰值，如果超过了峰值就进行fallback
    //超时3秒之后的进入默认处理
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_timeout_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeout(Long id) {
        //int timeout = 5000;
        int timeout = 2000;
        //出现异常时的错误处理
        int ret = 1 / 0;
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "当前线程号: " + Thread.currentThread().getName() + "\t: id " + "运行超时";
        return result;
    }

    @Override
    @HystrixCommand
    public String paymentI_global_timeout(Long id) {
        //int timeout = 5000;
        int timeout = 2000;
        //出现异常时的错误处理
        int ret = 1 / 0;
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "当前线程号: " + Thread.currentThread().getName() + "\t: id " + "运行超时";
        return result;
    }

    public String paymentInfo_timeout_handler(Long id) {
        return "线程池： " + Thread.currentThread().getName() + "\t id: " + id + "服务暂时不可用";
    }

    //全局异常处理的方法
    public String payment_global_fallBack(Long id) {
        return "线程池： " + Thread.currentThread().getName() + "\t id: " + id + "默认处理信息";
    }

    /////////////////////////////////////////////
    //服务熔断的方法处理，先进行降级，然后断路，等待准确的次数上升再恢复链路，从半开恢复到熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "100000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后断路
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("Id 不正确" + id);
        }
        String serialNumber = IdUtil.simpleUUID(); //UUID.randomUUID().toString()功能一样

        return Thread.currentThread().getName() + "\t id: " + id + "调用成功，版本号 " + serialNumber;
    }

    private String paymentCircuitFallBack(Long id) {
        return "id不能小于0 " + id;
    }
}
