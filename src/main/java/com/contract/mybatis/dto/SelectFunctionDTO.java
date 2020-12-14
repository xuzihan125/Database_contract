package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectFunctionDTO {
    @ApiModelProperty(value = "用户名")
    private String funname;
}
