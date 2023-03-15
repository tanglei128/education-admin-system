package com.tyy.educationadminsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyy.educationadminsystem.entity.Question;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.vo.QuestionVo;

public interface QuestionService extends IService<Question> {
    ResponseResult addQuestion(QuestionVo questionVo);
}
