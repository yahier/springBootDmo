package com.yahier.demo.controller;


import com.yahier.demo.component.TestAsync;
import com.yahier.demo.respository.CustomerRepository;
import com.yahier.demo.table.Customer;
import com.yahier.demo.util.JPushManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test1Controller {

    @Value("${user.name}")
    String userName;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TestAsync testAsync;



    @RequestMapping("/")
    String index() {
        return "hello. spring boot from Test1Controller userName:" + userName;
    }

    @RequestMapping("/testRedis")
    public String testRedis() {
        stringRedisTemplate.opsForValue().set("owner", "yahier");
        String value = stringRedisTemplate.opsForValue().get("owner");
        System.out.println("value:" + value);
        return "redis缓存的值是:" + value;
    }

    @RequestMapping("/testAsync")
    public String testAsync() {
        long start = System.currentTimeMillis();
        testAsync.test1();
        testAsync.test2();
        long end = System.currentTimeMillis();
        return "duration:" + (end - start);
    }

    @RequestMapping("/test")
    public String test() {
        return "hello. spring boot from Test1Controller userName:" + userName;
    }




    @RequestMapping("/push")
    public String push(){
        JPushManager.send();
        return "用极光 推送了一条Android信息";
    }
}
