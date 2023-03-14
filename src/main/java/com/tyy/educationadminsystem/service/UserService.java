package com.tyy.educationadminsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyy.educationadminsystem.entity.User;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.vo.PageVo;
import com.tyy.educationadminsystem.vo.UserVo;

import java.util.Map;

public interface UserService extends IService<User> {

    ResponseResult getUserByMap(Map map);

    ResponseResult getUserByPage(String id,Long current,Long size);

    ResponseResult login(String username,String pwd);

    ResponseResult insertUser(UserVo user);

    ResponseResult queryUser(String name, PageVo page);

}
