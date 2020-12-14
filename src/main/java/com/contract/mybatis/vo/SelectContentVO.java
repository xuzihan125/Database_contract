package com.contract.mybatis.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SelectContentVO {
    private boolean state;
    private String feedBack;
    private String conNum;
    private String customer;
    private String content;
    private Date beginTime;
    private Date endTime;
    private String userNum;
}
