package com.yahier.demo.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName
@Data
public class Dog {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String name;
}
