package com.tyy.educationadminsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tyy.educationadminsystem.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_question_option")
public class QuestionOption extends BaseEntity implements Serializable {
    private String id;
    private String qid;//题目id
    private String oid;//选项的编号 例如1,2
    private String content;//选项的内容
}
