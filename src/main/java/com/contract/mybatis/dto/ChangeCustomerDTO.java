package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ChangeCustomerDTO {
    @ApiModelProperty(value = "客户姓名")
    private List<String> name;
    @ApiModelProperty(value = "号码")
    private List<String> phone;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "传真")
    private String fax;
    @ApiModelProperty(value = "邮编")
    private String code;
    @ApiModelProperty(value = "银行名称")
    private String bank;
    @ApiModelProperty(value = "银行账户")
    private String account;
    @ApiModelProperty(value = "备注")
    private String comment;
}
