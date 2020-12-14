package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AddContractDTO {
    @ApiModelProperty(value = "合同名")
    private String name;
    @ApiModelProperty(value = "开始时间")
    private String beginTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
    @ApiModelProperty(value = "客户名")
    private String customer;
    @ApiModelProperty(value = "合同内容")
    private String content;
    @ApiModelProperty(value = "附件名")
    private String filename;
    @ApiModelProperty(value = "附件类型")
    private String type;
}
