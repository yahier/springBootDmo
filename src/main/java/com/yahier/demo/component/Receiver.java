package com.yahier.demo.component;

import com.yahier.demo.Constant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = Constant.queueName)
    public void receiveMessage(String message) {
        System.out.println("Receive < " + message);
    }
}
