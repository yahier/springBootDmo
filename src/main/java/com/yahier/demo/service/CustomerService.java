package com.yahier.demo.service;


import com.yahier.demo.mapper.CustomerMapper;
import com.yahier.demo.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List findAll() {
        return customerMapper.findAll();
    }

    public List searchList(String keyword) {
        return customerMapper.searchList(keyword);
    }

}
