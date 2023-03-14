package com.tyy.educationadminsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyy.educationadminsystem.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
