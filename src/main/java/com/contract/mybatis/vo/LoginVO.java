package com.contract.mybatis.vo;

import lombok.Data;

/**
 * 返回内容
 */
@Data
public class LoginVO {
    private boolean state;

    private String feedBack;

    private String usernum;
}
