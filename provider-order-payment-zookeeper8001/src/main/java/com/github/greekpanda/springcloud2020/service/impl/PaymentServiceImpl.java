package com.github.greekpanda.springcloud2020.service.impl;

import com.github.greekpanda.springcloud2020.dao.PaymentDAO;
import com.github.greekpanda.springcloud2020.entities.Payment;
import com.github.greekpanda.springcloud2020.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author greekpanda
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Resource
    private PaymentDAO paymentDAO;


    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
