package com.tyy.educationadminsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseVo extends PageVo{
    private String id;
    @ApiModelProperty(value = "学科名", required = true)
    private String courseName;
    @ApiModelProperty(value = "年级", required = true)
    private int grade;
}
