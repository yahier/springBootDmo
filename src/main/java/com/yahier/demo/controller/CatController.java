package com.yahier.demo.controller;

import cn.hutool.log.StaticLog;
import com.yahier.demo.entity.BaseResp;
import com.yahier.demo.service.CatService;
import com.yahier.demo.table.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * tip:好久都没有想到去设置postman中 header下的Content-Type，导致模拟请求不是很顺畅
 */
@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    /**
     * 单个添加
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public BaseResp add(@RequestBody Cat cat) {
        StaticLog.info("猫的type is {}", cat.getType());
        catService.save(cat);
        return new BaseResp(cat);
    }


    /**
     * 列表添加
     */
    @RequestMapping(value = "/addList", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public BaseResp addList(@RequestBody List<Cat> listCat) {
        catService.saveBatch(listCat);
        return new BaseResp(listCat);
    }

}
