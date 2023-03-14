package com.tyy.educationadminsystem.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.tyy.educationadminsystem.common.exception.BusinessException;
import com.tyy.educationadminsystem.entity.Course;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.CourseService;
import com.tyy.educationadminsystem.vo.CourseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Api(tags = "学科管理")
@RequestMapping("/v1/course")
public class CourseController {
    CourseService courseService;
//    @Autowired
//    CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @ApiOperation("创建学科")
    @ApiOperationSupport(ignoreParameters = {"course.id","course.createTime"})
    @PostMapping(value = "/add")
    public ResponseResult addCourse(@RequestBody Course course){
        course.setCreateTime(new Date());
        boolean b = courseService.saveOrUpdate(course);
       if(b){
           return ResponseResult.success();
       }
       throw new BusinessException("学科创建失败");
    }

    @ApiOperation("查询学科列表")
    @PostMapping(value = "/list")
    public ResponseResult queryCourse(@RequestBody CourseVo course){
       return courseService.queryCourse(course);
    }
}
