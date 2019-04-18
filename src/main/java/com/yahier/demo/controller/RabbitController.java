package com.yahier.demo.controller;

import com.yahier.demo.Constant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("send")
    public void send() {
        rabbitTemplate.convertAndSend(Constant.queueName, "你好，我是yahier");
    }
}
