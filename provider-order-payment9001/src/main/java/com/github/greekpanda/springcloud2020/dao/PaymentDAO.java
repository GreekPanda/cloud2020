package com.github.greekpanda.springcloud2020.dao;

import com.github.greekpanda.springcloud2020.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentDAO {
    public int create(Payment payment);
    public Payment getPaymentById(@PathVariable("id") Long id);
}
