package com.yahier.demo.respository;


import com.yahier.demo.table.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 注:除了JpaRepository，还可以使用CredRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * why？这个查询语句 是在哪里实现的呢
     */
    List<Customer> findByLastName(String lastName);

    List<Customer> findFirst(String key);

}
