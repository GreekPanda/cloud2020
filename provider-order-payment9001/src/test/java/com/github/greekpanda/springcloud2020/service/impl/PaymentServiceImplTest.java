package com.github.greekpanda.springcloud2020.service.impl;

import com.github.greekpanda.springcloud2020.dao.PaymentDAO;
import com.github.greekpanda.springcloud2020.entities.Payment;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PaymentServiceImplTest {

    @Resource
    public PaymentDAO paymentDAO;

    @Test
    public void create() {
        String serial = "test11111111";
        Payment payment = new Payment();
        payment.setSerial(serial);
        int ret = paymentDAO.create(payment);
        log.info("插入数据库之后的返回结果： " + ret);
    }

    @Test
    public void getPaymentById() {
        long id = 1;
        Payment payment = paymentDAO.getPaymentById(id);
        log.info("查询之后的数据库：" + payment.toString());
    }
}