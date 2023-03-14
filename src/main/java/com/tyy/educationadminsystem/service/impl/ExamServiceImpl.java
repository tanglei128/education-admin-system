package com.tyy.educationadminsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyy.educationadminsystem.entity.Exam;
import com.tyy.educationadminsystem.mapper.ExamMapper;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.ExamService;
import com.tyy.educationadminsystem.vo.ExamVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {

    @Override
    public ResponseResult queryExam(ExamVo examVo) {
        Exam exam = new Exam();
        BeanUtils.copyProperties(examVo,exam);
        QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Exam::getCid,exam.getCid()).eq(Exam::getGid,exam.getGid());
        Page<Exam> page = new Page<>(examVo.getCurrent(),examVo.getSize());
        Page<Exam> result = this.page(page, queryWrapper);
        return ResponseResult.success(result);
    }
}
