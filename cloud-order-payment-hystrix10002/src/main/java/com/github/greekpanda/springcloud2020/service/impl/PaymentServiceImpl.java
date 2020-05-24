package com.github.greekpanda.springcloud2020.service.impl;

import com.github.greekpanda.springcloud2020.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/4/28 0028 下午 2:43
 */
@Service
@Slf4j
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
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    public String paymentInfo_timeout(Long id) {
        //int timeout = 5000;
        int timeout = 2000;
        //出现异常时的错误处理
        int ret = 1/0;
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "当前线程号: " +  Thread.currentThread().getName() + "\t: id " + "运行超时";
        return result;
    }

    public String paymentInfo_timeout_handler(Long id) {
        return "线程池： " + Thread.currentThread().getName() + "\t id: " + id +  "服务暂时不可用";
    }
}
