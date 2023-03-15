package com.tyy.educationadminsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tyy.educationadminsystem.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_question")
public class Question extends BaseEntity implements Serializable {
    private String id;
    private int gid;//年级号
    private String cid;//学科id
    private int difficult;//难度
    private int questionType;//1.单选，2.多选,3.判断，4.填空，5.简答
    private double score;//题目分数
    private String userId;//创建人
    private String stem;//题干
    private String analysis;//解析
    private String correct;//正确答案，可以是简答题的答案，也可以是填空题的答案，
    private String correct_mark;// 正确答案,可以是单选题，多选题，判断题的题目内部编号

}