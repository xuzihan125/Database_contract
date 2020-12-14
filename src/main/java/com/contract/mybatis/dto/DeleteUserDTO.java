package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeleteUserDTO {
    @ApiModelProperty(value = "用户ID")
    private String num;
}