package com.contract.mybatis.vo;

import lombok.Data;

import java.util.List;

@Data
public class SelectFunctionVO {
    private boolean state;
    private String feedBack;
    private List<String> funnum;
    private List<String> funname;
    private List<String> funURL;
    private List<String> description;
}
