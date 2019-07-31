package com.yahier.demo.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName
@Data
public class Cat {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    private String color;

    private float weight;

    private int type;

    @TableField("habit_des")
    private String habitDes;
}
