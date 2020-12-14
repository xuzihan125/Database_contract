package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectContentDTO {
    @ApiModelProperty(value = "合同号")
    private String conNum;
}
