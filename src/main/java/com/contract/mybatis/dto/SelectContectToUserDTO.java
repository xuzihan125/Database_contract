package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectContectToUserDTO {
    @ApiModelProperty(value = "状态")
    private String type;
}
