package com.contract.mybatis.vo;

import lombok.Data;

@Data
public class LoginVO {
    private boolean state;

    private String feedBack;

    private String name;

    private String role;
}
