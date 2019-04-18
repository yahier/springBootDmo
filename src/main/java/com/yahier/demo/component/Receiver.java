package com.yahier.demo.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "myqueue1")
    public void receiveMessage(String message) {
        System.out.println("Receive < " + message);
    }
}
