package com.contract.mybatis.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class SelectContractVO {
    private boolean state;
    private String feedBack;
    private List<String> conNum;
    private List<String> conName;
    private List<Date> beginTime;
}
