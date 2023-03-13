package com.tyy.educationadminsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("t_user")
@Data
public class User extends BaseEntity implements Serializable{
    private String id;
    private String name;
    private String pwd;
    private String realName;
    private Integer age;
    private Integer sex;//0:女，1：男
    private Date birthday;
    private String phone;
    private Integer classNum;//年级号
    private Integer status;//状态0：禁用，1启用
}
