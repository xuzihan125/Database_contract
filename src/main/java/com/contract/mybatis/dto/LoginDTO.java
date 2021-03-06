package com.contract.mybatis.dto;
//得到值

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginDTO {
    @ApiModelProperty(value = "用户ID")
    private String num;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
