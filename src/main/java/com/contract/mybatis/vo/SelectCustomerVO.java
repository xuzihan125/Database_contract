package com.contract.mybatis.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SelectCustomerVO {
    private boolean state;
    private String feedBack;
    private List<String> name;
    private List<String> phone;
    private List<String> address;
    private List<String> fax;
    private List<String> code;
    private List<String> bank;
    private List<String> account;
    //private List<String> comment;
}
