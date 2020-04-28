package com.github.greekpanda.springcloud2020.dao;

import com.github.greekpanda.springcloud2020.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface PaymentDAO {
    int create(Payment payment);
    Payment getPaymentById(@PathVariable("id") Long id);
}
