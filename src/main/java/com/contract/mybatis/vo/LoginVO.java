package com.contract.mybatis.vo;

import lombok.Data;

import java.util.List;

/**
 * 返回内容
 */
@Data
public class LoginVO {
    private boolean state;

    private String feedBack;

    private String username;
}
