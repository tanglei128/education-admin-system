package com.tyy.educationadminsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageVo {
    @ApiModelProperty(value = "当前页", required = true)
    private Long current;
    @ApiModelProperty(value = "每页条数", required = true)
    private Long size;
}
