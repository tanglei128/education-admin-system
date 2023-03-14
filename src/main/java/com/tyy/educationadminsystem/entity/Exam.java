package com.tyy.educationadminsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_exam_paper")
public class Exam extends BaseEntity implements Serializable {
    private String id;
    private int gid;
    private String cid;
    private int type;
    private String name;
    private int duration;
}
