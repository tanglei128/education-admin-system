package com.tyy.educationadminsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyy.educationadminsystem.entity.Course;
import com.tyy.educationadminsystem.mapper.CourseMapper;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.CourseService;
import com.tyy.educationadminsystem.vo.CourseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {


    @Override
    public ResponseResult queryCourse(CourseVo courseVo) {
        Course course1 = new Course();
        BeanUtils.copyProperties(courseVo,course1);
        Page<Course> pageParam  = new Page<>(courseVo.getCurrent(),courseVo.getSize());
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(courseVo.getCourseName())){
            queryWrapper.lambda().eq(Course::getCourseName,courseVo.getCourseName());
        }
        Page<Course> page = this.page(pageParam, queryWrapper);
        return ResponseResult.success(page);
    }
}
