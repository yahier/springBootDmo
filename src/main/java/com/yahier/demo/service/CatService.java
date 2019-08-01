package com.yahier.demo.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.yahier.demo.mapper.CatMapper;
import com.yahier.demo.table.Cat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现mybatis扩展方法的类
 */
@Service
public class CatService extends ServiceImpl<CatMapper, Cat> {


    /**
     * 按条件查询
     */
    public List<Cat> searchList(String color) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(true, "color", color);
        return list(wrapper);
    }

    /**
     * 按条件更新
     */
    public void update_() {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", "1156462940657094658");
        wrapper.set("color", "black");
        update(wrapper);

    }


}
