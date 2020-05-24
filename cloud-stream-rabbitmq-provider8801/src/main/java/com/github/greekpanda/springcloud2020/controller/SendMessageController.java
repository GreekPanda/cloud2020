package com.github.greekpanda.springcloud2020.controller;

import com.github.greekpanda.springcloud2020.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/24 20:53
 */
@RestController
@Slf4j
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendmsg")
    public String sendMessage() {
        return messageProvider.send();
    }
}
