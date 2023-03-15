package com.tyy.educationadminsystem.vo;

import lombok.Data;

@Data
public class QuestionOptionVo {
    private String id;
    private String qid;//题目id
    private String oid;//选项的编号 例如1,2
    private String content;//选项的内容
}
