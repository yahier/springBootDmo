package com.yahier.demo.controller;

import com.yahier.demo.respository.CustomerRepository;
import com.yahier.demo.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public List<Customer> list() {
        long count = repository.count();
        System.out.println("count:" + count);
        List<Customer> list = repository.findAll();
        if (count > 0) {
            System.out.println("0号Customer:" + list.get(0).toString());
        }
        return list;
    }


    /**
     * 测试，单个客户端 循环执行500次 耗时约1040毫秒
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Customer add() {
        int index = new Random().nextInt(100);
        Customer customer = new Customer("xu" + index, "ziwang" + index);
        repository.save(customer);
        return customer;
    }
}
