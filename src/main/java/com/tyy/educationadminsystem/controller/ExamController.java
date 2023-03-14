package com.tyy.educationadminsystem.controller;

import com.tyy.educationadminsystem.common.exception.BusinessException;
import com.tyy.educationadminsystem.entity.Exam;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.ExamService;
import com.tyy.educationadminsystem.vo.ExamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "试卷库管理")
@RequestMapping("/v1/exam")
public class ExamController {
    @Autowired
    ExamService examService;

    @ApiOperation("创建试卷")
    @PostMapping(value = "/add")
    public ResponseResult addExam(@RequestBody Exam exam){
        boolean b = examService.saveOrUpdate(exam);
        if (b){
            return ResponseResult.success();
        }
        throw new BusinessException("试卷创建失败");
    }

    @ApiOperation("查询试卷列表")
    @PostMapping(value = "/list")
    public ResponseResult queryExam(@RequestBody ExamVo exam){
        return examService.queryExam(exam);
    }
}
