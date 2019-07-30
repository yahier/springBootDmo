package com.yahier.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    List findAll();

    List searchList(@Param(value="keyword")String keyword);

}
