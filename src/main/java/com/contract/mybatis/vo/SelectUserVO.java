package com.contract.mybatis.vo;

import lombok.Data;

import java.util.List;

@Data
public class SelectUserVO {
    private boolean state;

    private String feedBack;

    private List<String> num;

    private List<String> name;
}