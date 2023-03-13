package com.tyy.educationadminsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@TableName("t_user")
@Data
public class User implements Serializable {
    private String id;
    private String name;
    private String pwd;
}
