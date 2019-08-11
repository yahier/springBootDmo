package com.yahier.demo.controller;

import cn.hutool.log.StaticLog;
import com.yahier.demo.entity.BaseResp;
import com.yahier.demo.service.CatService;
import com.yahier.demo.table.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public BaseResp add(Cat cat) {
        StaticLog.info("猫的type is {}", cat.getType());
        catService.save(cat);
        return new BaseResp(cat);
    }


    @RequestMapping(value = "/addList", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public BaseResp addList(Cat cat) {
        List<Cat> listCat = new ArrayList<>();
        listCat.add(new Cat());
        listCat.add(new Cat());
        catService.saveBatch(listCat);
        return new BaseResp(true);
    }

}
