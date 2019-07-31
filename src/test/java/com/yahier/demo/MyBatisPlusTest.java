package com.yahier.demo;

import cn.hutool.log.StaticLog;
import com.yahier.demo.mapper.CatMapper;
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

    @Test
    public void test1() {
        List<Cat> list1 = catMapper.selectList(null);
        StaticLog.info("list的数量是{}", list1.size());

        testInsert();

        List<Cat> list2 = catMapper.selectList(null);
        StaticLog.info("list的数量是{}", list2.size());
    }

    @Test
    public void testInsert() {
        Cat cat = new Cat();
        cat.setColor("黑色");
        cat.setType(1);
        cat.setHabitDes("like silence");
        cat.setWeight(6.5f);
        catMapper.insert(cat);
    }

}
