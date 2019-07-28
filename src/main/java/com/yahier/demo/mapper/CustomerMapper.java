package com.yahier.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    List findAll();
}
