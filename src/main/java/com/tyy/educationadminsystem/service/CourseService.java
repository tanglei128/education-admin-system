package com.tyy.educationadminsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyy.educationadminsystem.entity.Course;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.vo.CourseVo;

public interface CourseService extends IService<Course> {
    ResponseResult queryCourse(CourseVo courseVo);
}
