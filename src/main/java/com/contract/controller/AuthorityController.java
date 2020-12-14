package com.contract.controller;

import com.contract.mybatis.entity.Log;
import com.contract.service.LogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Authority")
public class AuthorityController {
    @Resource
    private LogService service;

    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/getLog",method= RequestMethod.GET)
    public List<Log> getLog(@RequestBody long size, @RequestHeader(value = "num") String opnum){
        return service.getLog(size,opnum);
    }
}

