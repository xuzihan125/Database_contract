package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectUserDTO {
    @ApiModelProperty(value = "用户ID")
    private String num;
    @ApiModelProperty(value = "用户名")
    private String name;
}