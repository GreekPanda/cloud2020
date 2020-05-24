package com.github.greekpanda.springcloud2020.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/24 21:08
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class StreamMessageReceiverController {

    @Value("${server.port}")
    private String svrPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("Receive message from mq" + message.getPayload());
    }
}
