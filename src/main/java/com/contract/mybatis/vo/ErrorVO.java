package com.contract.mybatis.vo;

import lombok.Data;

@Data
public class ErrorVO {
    private boolean state;

    private String feedBack;

    public ErrorVO(boolean state, String feedBack){
        this.state = state;
        this.feedBack = feedBack;
    }
}
