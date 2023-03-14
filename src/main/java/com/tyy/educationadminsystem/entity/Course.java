package com.tyy.educationadminsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

import java.io.Serializable;

@TableName("t_course")
@Data
public class Course extends BaseEntity implements Serializable {
    private String id;
    private String courseName;
    private int grade;
}
