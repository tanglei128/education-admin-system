package com.tyy.educationadminsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyy.educationadminsystem.common.exception.AuthException;
import com.tyy.educationadminsystem.common.exception.BusinessException;
import com.tyy.educationadminsystem.entity.User;
import com.tyy.educationadminsystem.mapper.UserMapper;
import com.tyy.educationadminsystem.result.ResponseResult;
import com.tyy.educationadminsystem.service.UserService;
import com.tyy.educationadminsystem.utils.ConstantUtil;
import com.tyy.educationadminsystem.utils.RedisUtil;
import com.tyy.educationadminsystem.vo.PageVo;
import com.tyy.educationadminsystem.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public ResponseResult getUserByMap(Map map) {
        List list = userMapper.selectByMap(map);
        return  ResponseResult.success();
    }

    @Override
    public ResponseResult getUserByPage(String id,Long current,Long size) {
        //创建page对象
        Page<User> pageParam = new Page<>(current, size);
        //调用方法实现条件查询分页
        Page<User> page = userService.page(pageParam, null);
//        List<User> records = pageParam.getRecords();//数据list集合
//        long total = pageParam.getTotal();//获取总记录数
        return ResponseResult.success(page);
    }

    @Override
    public ResponseResult login(String username, String pwd) {
        if(StringUtils.isBlank(username)||StringUtils.isBlank(pwd)){
            throw new AuthException("用户名或密码不能为空！");
        }
        User user = new User();
        user.setName(username);
        user.setPwd(pwd);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",username);
        queryWrapper.eq("pwd",pwd);
        User user1 = userMapper.selectOne(queryWrapper);
        if (null!=user1){
            String token = UUID.randomUUID().toString();
//            设置为60s
            redisUtil.set(token,username, ConstantUtil.REDIS_ALIVE_TIME);
            return ResponseResult.success(token);
        }
        throw new AuthException("登录失败");
    }

    @Override
    public ResponseResult insertUser(UserVo user) {
        User user0 =new User();
        BeanUtils.copyProperties(user,user0);
        user0.setCreateTime(new Date());
//        String id =UUID.randomUUID().toString().replace("-","");
//        System.out.println("id::"+id);
//        user0.setId(id);
        int insert = userMapper.insert(user0);
        if (insert>0){
            return ResponseResult.success();
        }
        throw new BusinessException("用户创建失败");
    }

    @Override
    public ResponseResult queryUser(String name, PageVo page) {
        Page<User> pageParam = new Page<>(page.getCurrent(), page.getSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (null!=name&&!("".equals(name))){
            wrapper.lambda().eq(User::getName,name);
        }
        Page<User> userPage = userMapper.selectPage(pageParam, wrapper);
        return ResponseResult.success(userPage);
    }
}
