package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.LogMapper;
import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.entity.LogExample;
import com.contract.service.LogService;
import com.contract.util.emnu.EnumCamp;
import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogMapper logMapper;

    @Resource
    private SelectAuthorityTools right;

    @Override
    public boolean saveLog(String opnum, String content){
        Log log = new Log();
        log.setUsernum(opnum);
        log.setTime(new Date());
        log.setContent(content);
        logMapper.insert(log);
        try{
            logMapper.insert(log);
        }
        catch (Exception e){
            throw new ActException(ErrorCode.LOG_ERROR.getCode(),ErrorCode.LOG_ERROR.getName());
        }
        return true;
    }

    //获得日志
    @Override
    public List<Log> getLog(long size,String opnum){
        //效验授权
        if(!right.selectAuthority(opnum, EnumCamp.Right.CHECK_LOG.getCode())){
            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
        }
        //提取日志
        LogExample example = new LogExample();
        example.createCriteria();
        List<Log> entityList = logMapper.selectByExample(example);
        //按照要求，取最新的日志
        int totalSize = entityList.size();
        List<Log> returnList = new ArrayList<>();
        for(int i=0;i<size && i < totalSize;i++){
            returnList.add(entityList.get(totalSize-1-i));
        }
        saveLog(opnum,"查询日志");
        return returnList;
    }
    
}
