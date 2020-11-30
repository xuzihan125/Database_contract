package com.contract.controller.test;

import com.contract.mybatis.dto.ClassDTO;
import com.contract.mybatis.entity.SClass;
import com.contract.service.serviceImpl.ClassServiceImpl;
import com.contract.util.BaseAction.BaseAction;
import com.contract.util.message.JsonMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api("演示接口")
@CrossOrigin(origins = "http://192.168.1.10:8080", maxAge = 3600)
@RestController//这个一定要加
@RequestMapping(value = "/class")
public class ClassController {
    @Resource
    private ClassServiceImpl service;

    @ApiOperation(value = "方法描述:演示模板过程,请求方式:GET,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/getClass",method= RequestMethod.GET)
    public List<SClass> GetClass(@RequestBody ClassDTO classDTO){
        return service.GetSelectClass(classDTO);
    }

    @ApiOperation(value = "方法描述:演示模板过程,请求方式:GET,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String Test(){
        return "hello world";
    }

}
