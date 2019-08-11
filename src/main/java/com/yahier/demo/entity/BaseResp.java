package com.yahier.demo.entity;

import lombok.Data;

@Data
public class BaseResp {
    private int code;
    private String msg;
    private Object data;


    public BaseResp(boolean isSuccess) {
        if (isSuccess) {
            code = 200;
            msg = "操作成功";
        } else {
            code = 201;
            msg = "操作失败";
        }

    }

    public BaseResp(Object data) {
        code = 200;
        msg = "操作成功";
        this.data = data;
    }

}
