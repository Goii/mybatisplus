package com.levi.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private String id;
    private String name;
    private String age;
    private String email;
    @TableField("type")
    private String type;
    @TableLogic
    private Integer deleted;

    @TableField(exist = false)
    private Type type2;
}
