package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectContractOrStateDTO {
    @ApiModelProperty(value = "合同名")
    private String conName;

    @ApiModelProperty(value = "状态")
    private String state;
}
