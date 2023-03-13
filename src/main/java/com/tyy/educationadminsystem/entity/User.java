package com.tyy.educationadminsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date birthday;
    private String phone;
    private Integer classNum;//年级号
    private Integer status;//状态0：禁用，1启用
}
