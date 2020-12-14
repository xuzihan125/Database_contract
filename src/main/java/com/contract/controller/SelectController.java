package com.contract.controller;

import com.contract.mybatis.dto.*;
import com.contract.mybatis.vo.*;
import com.contract.service.SelectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController(value = "/select")
public class SelectController {
    @Resource
    private SelectService service;
    @ApiOperation(value = "方法描述:查询用户,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/selectuser",method= RequestMethod.GET)
    public SelectUserVO selectuser(@RequestBody SelectUserDTO selectUserDTO, @RequestHeader(value = "num") String opnum)
    { return service.selectuser(selectUserDTO,opnum);}

    @ApiOperation(value = "方法描述:查询客户,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/selectcustomer",method= RequestMethod.GET)
    public SelectCustomerVO selectcustomer(@RequestBody SelectCustomerDTO selectCustomerDTO, @RequestHeader(value = "num") String opnum)
    { return service.selectcustomer(selectCustomerDTO,opnum);}

    @ApiOperation(value = "方法描述:查询全部功能,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/selectfunction",method= RequestMethod.GET)
    public SelectFunctionVO selectfunction(@RequestBody SelectFunctionDTO dto, @RequestHeader(value = "num") String opnum)
    { return service.selectfunction(dto,opnum);}

    @ApiOperation(value = "方法描述:查询合同列表,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/selectcontract",method= RequestMethod.GET)
    public SelectContractVO selectcontract(@RequestBody SelectContractOrStateDTO dto, @RequestHeader(value = "num") String opnum)
    { return service.selectcontract(dto,opnum);}

    @ApiOperation(value = "方法描述:查询合同操作人员,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/selectright",method= RequestMethod.GET)
    public SelectUserVO selectright(@RequestBody SelectRightDTO dto, @RequestHeader(value = "num") String opnum)
    { return service.selectright(dto,opnum);}

    @ApiOperation(value = "方法描述:查询某操作人待**的合同,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/selectwaitingcontract",method= RequestMethod.GET)
    public SelectContractVO selectcontracttouser(@RequestBody SelectContectToUserDTO dto, @RequestHeader(value = "num") String opnum)
    { return service.selectcontracttouser(dto,opnum);}

    @ApiOperation(value = "方法描述:查询合同具体内容,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/selectcontent",method= RequestMethod.GET)
    public SelectContentVO selectcontent(@RequestBody SelectContentDTO dto, @RequestHeader(value = "num") String opnum)
    { return service.selectcontent(dto,opnum);}
}