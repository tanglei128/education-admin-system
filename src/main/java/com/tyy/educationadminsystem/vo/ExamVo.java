package com.tyy.educationadminsystem.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tyy.educationadminsystem.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_exam_paper")
public class ExamVo extends PageVo{
    private String id;
    private int gid;
    private String cid;
    private int type;
    private String name;
    private int duration;
}
