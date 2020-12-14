package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectCustomerDTO {
    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "电话")
    private String phone;
}
