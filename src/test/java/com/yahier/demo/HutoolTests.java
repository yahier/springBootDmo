package com.yahier.demo;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.yahier.demo.entity.CustomerBean;
import com.yahier.demo.table.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HutoolTests {

    @Test
    public void contextLoads() {
        StaticLog.info("8号");
    }


    /**
     * 缓存测试，hutool的缓存说基于内存的
     */
    @Test
    public void testCacheUtil() {
        Cache<String, String> cacheUtil = CacheUtil.newFIFOCache(10);
        cacheUtil.put("key1", "i am key1", DateUnit.SECOND.getMillis() * 10);

        try {
            String value1 = cacheUtil.get("key1");
            StaticLog.info("value1 is {}", value1);
            Thread.sleep(DateUnit.SECOND.getMillis() * 10);
            String value1_1 = cacheUtil.get("key1");
            StaticLog.info("value1 is {}", value1_1);//过期后，返回了null
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 有许多种转换途。也能将map,xml，javabean各种不同的对象转换成JSONObject
     */
    @Test
    public void testJson() {
        CustomerBean bean = new CustomerBean();
        bean.setId(800);
        bean.setName("bingo呀");
        JSONObject jo = JSONUtil.parseObj(bean);
        StaticLog.info("jo is {}", jo.toString());//过期后，返回了null
    }

    /**
     * DateUtil有各种时间相关方法，转换，获取，比较
     */
    @Test
    public void testDateUtil() {
        String dateStr = "2019-04-12";
        Date date = Convert.toDate(dateStr);
        String dateStr2 = DateUtil.format(date, "yyyy-MM-dd");
        StaticLog.info("dateStr2 is {}", dateStr2);

        int year = DateUtil.year(date);
        int month = DateUtil.month(date);
        StaticLog.info("year is {},month is {}", year, month);
    }


    @Test
    public void testStringUtil() {
        //格式化Str
        String template = "亲爱的{},老子该是多么的爱你呀，{}说";
        String strSentence = StrUtil.format(template, "燕妮", "王二");
        StaticLog.info(strSentence);

        //安全的sub
        String str = "123456789";
        String str1 = StrUtil.sub(str, 5, 2);//写错了，也能反转纠正
        String str2 = StrUtil.sub(str, 8, 10);//越界能安全停止
        String str3 = StrUtil.sub(str, 2, 2);
        StaticLog.info("str1 is {},str2 is {},str3 is {}", str1, str2, str3);

    }

    /**
     * 集合工具类
     */
    @Test
    public void testCollectionUtil() {
        List<Integer> list = CollUtil.toList(1, 2, 3);
        list.forEach(integer -> {
            System.out.println(integer);
        });
    }


    /**
     * 单例。除非调用destroy或者remove方法，不然每次取得相同对象
     */
    @Test
    public void testSingleTon() {
        CustomerBean bean1 = Singleton.get(CustomerBean.class);
        CustomerBean bean2 = Singleton.get(CustomerBean.class);
        System.out.println("bean1 equals bean2 " + (bean1 == bean2));
    }


    /**
     * 注意，当两个对象都有相同的id字段时，target bean中的id不能为空。否则会主注入失败
     */
    @Test
    public void testBeanUtil() {
        Customer customer = new Customer(null,"ziwang");
        customer.setId(123L);
        CustomerBean bean = new CustomerBean();
        BeanUtil.copyProperties(customer, bean);
        System.out.println(bean.getFirstName());
    }
}
