package com.tyy.educationadminsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyy.educationadminsystem.entity.Exam;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.vo.ExamVo;

public interface ExamService extends IService<Exam> {
    ResponseResult queryExam(ExamVo examVo);
}
