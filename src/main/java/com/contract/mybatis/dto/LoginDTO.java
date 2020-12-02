package com.contract.mybatis.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginDTO {
    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
