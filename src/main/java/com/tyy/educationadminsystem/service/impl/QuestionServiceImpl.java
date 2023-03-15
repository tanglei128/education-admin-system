package com.tyy.educationadminsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyy.educationadminsystem.entity.QuestionOption;
import com.tyy.educationadminsystem.mapper.QuestionMapper;
import com.tyy.educationadminsystem.mapper.QuestionOptionMapper;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.QuestionService;
import com.tyy.educationadminsystem.entity.Question;
import com.tyy.educationadminsystem.utils.CopyUtil;
import com.tyy.educationadminsystem.vo.QuestionOptionVo;
import com.tyy.educationadminsystem.vo.QuestionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Autowired
    QuestionOptionMapper questionOptionMapper;

    @Autowired
    QuestionMapper questionMapper;


    @Override
    public ResponseResult addQuestion(QuestionVo questionVo) {
        Question question =new Question();
        BeanUtils.copyProperties(questionVo,question);
//        boolean save = this.save(question);
        int insert = questionMapper.insert(question);
        String qid = question.getId();
        System.out.println("qid:"+qid);
        List<QuestionOptionVo> options = questionVo.getOptions();
        List<QuestionOption> questionOptions = CopyUtil.copyList(options, QuestionOption.class);
        questionOptions.forEach(item->{
            item.setQid(qid);
            item.setCreateTime(new Date());
            questionOptionMapper.insert(item);
        });
        return ResponseResult.success();
    }
}
