package com.tyy.educationadminsystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.Date;
@Data
public class UserVo implements Serializable {
    private String id;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    @ApiModelProperty(value = "密码", required = true)
    private String pwd;
    private String realName;
    private Integer age;
    private Integer sex;//0:女，1：男
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date birthday;
    private String phone;
    private Integer classNum;//年级号
    private Integer status;//状态0：禁用，1启用
}
