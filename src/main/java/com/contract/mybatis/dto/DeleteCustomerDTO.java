package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeleteCustomerDTO {
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "电话")
    private String phone;
}
