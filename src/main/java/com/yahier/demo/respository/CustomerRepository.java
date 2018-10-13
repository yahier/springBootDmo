package com.yahier.demo.respository;


import com.yahier.demo.table.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 注:除了JpaRepository，还可以使用CredRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * 名称约定
     */
    List<Customer> findByLastName(String lastName);

    List<Customer> findFirst(String key);

}
