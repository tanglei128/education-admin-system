package com.tyy.educationadminsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserVo{
    private String id;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    @ApiModelProperty(value = "密码", required = true)
    private String pwd;
    private String realName;
    private Integer age;
    private Integer sex;//0:女，1：男
    private String birthday;
    private String phone;
    private Integer classNum;//年级号
    private Integer status;//状态0：禁用，1启用
}
