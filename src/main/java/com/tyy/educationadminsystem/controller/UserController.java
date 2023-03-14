package com.tyy.educationadminsystem.controller;

import com.tyy.educationadminsystem.common.exception.BusinessException;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.UserService;
import com.tyy.educationadminsystem.utils.ConstantUtil;
import com.tyy.educationadminsystem.vo.PageVo;
import com.tyy.educationadminsystem.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户管理")
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET,produces = ConstantUtil.JSON_PRODUCES)
    public ResponseResult login(String username,String pwd){
        ResponseResult login = userService.login(username, pwd);
        return login;
    }

    @ApiOperation("注册用户接口")
    @PostMapping(value = "/register")
    public ResponseResult insertUser(@RequestBody UserVo user){
        return userService.insertUser(user);
    }

    @ApiOperation("查询用户列表")
    @PostMapping (value = "/query")
        public ResponseResult queryUser(@RequestParam Long current,@RequestParam Long size,@RequestParam(required=false) String name ){
        PageVo page = new PageVo(current,size);
        return userService.queryUser(name,page);
    }
}
