package com.yahier.demo.controller;

import cn.hutool.log.StaticLog;
import com.yahier.demo.entity.CustomerBean;
import com.yahier.demo.respository.CustomerRepository;
import com.yahier.demo.service.CustomerService;
import com.yahier.demo.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerService customerService;

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

    @RequestMapping(value = "/listByMybatis", produces = {"application/json;charset=UTF-8"})
    public List listByMybatis() {
        List list = customerService.findAll();
        return list;
    }

    @RequestMapping(value = "/getOne", produces = {"application/json;charset=UTF-8"})
    public Customer getOne(long id) {
        Customer list = customerService.getOne(id);
        return list;
    }


    @RequestMapping(value = "/getOneConverted", produces = {"application/json;charset=UTF-8"})
    public CustomerBean getOneConverted(long id) {
        return customerService.getOneConverted(id);
    }

    /**
     * 测试时，接收到了GET请求的传参
     */
    @RequestMapping(value = "/searchList", produces = {"application/json;charset=UTF-8"})
    public List<Customer> searchList(String keyword, HttpServletRequest request) {
        //String keyword2 = (String) request.getAttribute("keyword");
        StaticLog.info("info keyword = {}", keyword);
        List<Customer> list = customerService.searchList(keyword);
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
