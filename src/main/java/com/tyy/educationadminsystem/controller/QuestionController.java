package com.tyy.educationadminsystem.controller;


import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.QuestionService;
import com.tyy.educationadminsystem.vo.QuestionOptionVo;
import com.tyy.educationadminsystem.vo.QuestionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "考题库管理")
@RestController
@RequestMapping("/v1/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @ApiOperation("新增题目")
    @PostMapping("/add")
    public ResponseResult addQuestion(@RequestBody QuestionVo questionVo){
        return questionService.addQuestion(questionVo);
    }


}
