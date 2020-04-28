package com.github.greekpanda.springcloud2020.service.impl;

import com.github.greekpanda.springcloud2020.service.IPaymentService;
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

    @Override
    public String paymentInfo_timeout(Long id) {
        int timeout = 3000;
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "当前线程号: " +  Thread.currentThread().getName() + "\t: id " + "运行超时";
        return result;
    }
}
