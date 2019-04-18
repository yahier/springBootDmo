package com.yahier.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("yahier")
    public String index() {
        return "hello spring boot";
    }

    /**
     * 定义目的队列
     *
     * @return
     */
    @Bean
    public Queue takeQueue() {
        return new Queue("my_queue");
    }

    //此方法需要当前类实现CommandLineRunner接口，然而直接运行出错
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("application-run");
//        /**
//         * 向队列发送消息
//         */
//        rabbitTemplate.convertAndSend("my_queue", "你好呀-rabbit");
//    }
}
