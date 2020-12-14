package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountersignDTO {
    @ApiModelProperty(value = "合同号")
    private String conNum;
    @ApiModelProperty(value = "会签内容")
    private String content;
}
