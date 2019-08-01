package com.yahier.demo;

import cn.hutool.log.StaticLog;
import com.yahier.demo.mapper.CatMapper;
import com.yahier.demo.service.CatService;
import com.yahier.demo.table.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private CatMapper catMapper;

    @Autowired
    private CatService catService;

    @Test
    public void list() {
        // List<Cat> list1 = catMapper.selectList(null);
        // StaticLog.info("list的数量是{}", list1.size());

        testInsert();
        testInsert2();

        List<Cat> list2 = catService.searchList("yellow");
        StaticLog.info("list的数量是{}", list2.size());
    }

    @Test
    public void update() {
        catService.update_();

    }


    @Test
    public void testInsert() {
        Cat cat = new Cat();
        cat.setColor("yellow");
        cat.setType(1);
        cat.setHabitDes("like silence");
        cat.setWeight(6.5f);
        int num = catMapper.insert(cat);
        StaticLog.info("num is {}", num);
    }

    @Test
    public void testInsert2() {
        Cat cat = new Cat();
        cat.setColor("white");
        cat.setType(1);
        cat.setHabitDes("like silence");
        cat.setWeight(1.5f);
        boolean isSuccess = catService.save(cat);
        StaticLog.info("isSuccess is {}", isSuccess);
    }

}
