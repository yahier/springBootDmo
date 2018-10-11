package com.yahier.demo.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Entity

/**
 * 在这里，试验模糊语句时，提示失败，并且怎么建立多个查询语句呢
 */
@NamedQuery(name = "Customer.findFirst", query = "select c from Customer c where c.firstName=?1")
//@NamedQuery(name = "Customer.findX", query = "select c from Customer c where c.firstName=?1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore  //此注解表明，对外输出对象的json数据时，此字段将忽略(移除)
    private String firstName;
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    @JsonInclude(JsonInclude.Include.NON_NULL)//标明，此字段不为空时，才包含
    private String des;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        birthday = new Date();
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


    /***
     * 备注 当没有以下这些set/get方法时，CustomerController的方法返回都是空数据
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String desc) {
        this.des = desc;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}