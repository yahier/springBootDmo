package com.yahier.demo.mapper;

import com.yahier.demo.entity.CustomerBean;
import com.yahier.demo.table.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    //mark 这里，指定了泛型Customer后，才操作成功。
    @Select("select * from customer")
    List<Customer> getList();


    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "firstName"),
    })
    @Select("select * from customer where id = #{id}")
    CustomerBean getOneConverted(long id);


    @Select("select * from customer where id = #{id}")
    Customer getOne(long id);


    List searchList(@Param(value = "keyword") String keyword);

}
