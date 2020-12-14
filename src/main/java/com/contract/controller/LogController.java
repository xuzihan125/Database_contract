package com.contract.controller;

import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.dto.UsertoContractDTO;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.vo.LoginVO;
import com.contract.service.LogService;
import com.contract.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    @Resource
    private LogService service;
    //private RegisterService service1;
    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/getLog",method= RequestMethod.GET)
    public List<Log> getLog(@RequestBody long size, @RequestHeader(value = "num") String opnum){
        return service.getLog(size,opnum);
    }
}
