package com.tyy.educationadminsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyy.educationadminsystem.entity.QuestionOption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionOptionMapper extends BaseMapper<QuestionOption> {
}
