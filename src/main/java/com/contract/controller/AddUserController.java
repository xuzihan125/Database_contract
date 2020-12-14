package com.contract.controller;

import com.contract.Exception.ActExceptionHandler;
import com.contract.mybatis.dto.AddContractDTO;
import com.contract.mybatis.dto.AddCustomerDTO;
import com.contract.mybatis.dto.CountersignDTO;
import com.contract.mybatis.dto.RegisterDTO;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.AddService;
import com.contract.service.RegisterService;
import com.contract.util.BaseAction.BaseAction;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/add")
public class AddUserController extends BaseAction {
    @Resource
    private RegisterService service;
    @Resource
    private AddService service1;
    @ApiOperation(value = "方法描述:添加用户,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/checkadduser",method= RequestMethod.GET)
    public RegisterVO checkRegister(@RequestBody RegisterDTO RegisterDTO, @RequestHeader(value = "num") String opnum){
        return service.checkRegister(RegisterDTO,opnum);
    }

    @ApiOperation(value = "方法描述:添加客户,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/addcustomer",method= RequestMethod.GET)
    public RegisterVO AddCustomer(@RequestBody AddCustomerDTO dto, @RequestHeader(value = "num") String opnum){
        return  service1.AddCustomer(dto,opnum);
    }

    @ApiOperation(value = "方法描述:添加合同,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/addcontract",method= RequestMethod.GET)
    public RegisterVO AddContract(@RequestBody AddContractDTO dto, @RequestHeader(value = "num") String opnum){
        return  service1.AddContract(dto,opnum);
    }

    @ApiOperation(value = "方法描述:添加会签,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/addcountersign",method= RequestMethod.GET)
    public RegisterVO AddCountersign(@RequestBody CountersignDTO dto, @RequestHeader(value = "num") String opnum) throws ParseException {
        return  service1.AddCountersign(dto,opnum);
    }
}