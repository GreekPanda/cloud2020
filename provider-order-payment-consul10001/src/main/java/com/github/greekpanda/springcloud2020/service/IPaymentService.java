package com.github.greekpanda.springcloud2020.service;


import com.github.greekpanda.springcloud2020.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@PathVariable("id") Long id);
}
