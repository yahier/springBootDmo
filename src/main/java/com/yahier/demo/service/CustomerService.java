package com.yahier.demo.service;


import com.yahier.demo.entity.CustomerBean;
import com.yahier.demo.mapper.CustomerMapper;
import com.yahier.demo.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> findAll() {
        return customerMapper.getList();
    }

    public Customer getOne(long id) {
        return customerMapper.getOne(id);
    }

    public CustomerBean getOneConverted(long id) {
        return customerMapper.getOneConverted(id);
    }

    public List searchList(String keyword) {
        return customerMapper.searchList(keyword);
    }

}
