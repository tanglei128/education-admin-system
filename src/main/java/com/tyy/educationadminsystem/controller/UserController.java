package com.tyy.educationadminsystem.controller;

import com.tyy.educationadminsystem.common.exception.BusinessException;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.UserService;
import com.tyy.educationadminsystem.utils.ConstantUtil;
import com.tyy.educationadminsystem.vo.UserVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户管理")
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/add")
    public ResponseResult insertUser(@RequestBody UserVo user){
        return userService.insertUser(user);
    }
}
