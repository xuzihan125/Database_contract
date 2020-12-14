package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectRightDTO {
    @ApiModelProperty(value = "合同号")
    private String conNum;
    @ApiModelProperty(value = "权限")
    private String right;
}
