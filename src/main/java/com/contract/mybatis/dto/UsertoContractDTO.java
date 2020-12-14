package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UsertoContractDTO {
    @ApiModelProperty(value = "合同号")
    private String conNum;
    @ApiModelProperty(value = "操作人号")
    private List<String> userNum;
    @ApiModelProperty(value = "操作类型")
    private List<String> type;
}

