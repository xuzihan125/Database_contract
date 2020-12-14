package com.contract.service;

import com.contract.mybatis.entity.Log;

import java.util.List;

public interface LogService {
    boolean saveLog(String opnum, String content);

    List<Log> getLog(long size,String opnum);
}
