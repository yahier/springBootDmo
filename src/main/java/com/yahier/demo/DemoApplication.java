package com.yahier.demo;

import cn.hutool.cron.CronUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.mybatis.spring.annotation.MapperScan;

@RestController
@SpringBootApplication
@MapperScan(value = {"com.yahier.demo.mapper"})
public class DemoApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    /**
     * 启动定时任务，时间规则定义再resources/config/cron.setting文件中
     */
    private void startHutoolCron() {
        CronUtil.setMatchSecond(true);//若不设置，默认不知道秒级
        CronUtil.start();
    }

    @RequestMapping("yahier")
    public String index() {
        return "hello spring boot";
    }

    /**
     * 建议新队列，也可以在网站rabbitMQ网站上建立。
     */
//    @Bean
//    public Queue createQueue() {
//        return new Queue(Constant.queueName);
//    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("application-run");
    }
}
