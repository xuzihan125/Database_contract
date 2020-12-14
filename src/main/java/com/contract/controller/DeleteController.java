package com.contract.controller;

import com.contract.mybatis.dto.DeleteCustomerDTO;
import com.contract.mybatis.dto.DeleteUserDTO;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.DeleteUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController(value = "/delete")
public class DeleteController {
    @Resource
    private DeleteUserService service;

    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/deleteuser",method= RequestMethod.GET)
    public RegisterVO deleteuser(@RequestBody DeleteUserDTO deleteUserDTO, @RequestHeader(value = "num") String opnum)
    { return service.deleteuser(deleteUserDTO,opnum);}

    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/deletecustomer",method= RequestMethod.GET)
    public RegisterVO deletecustomer(@RequestBody DeleteCustomerDTO deleteCustomerDTO, @RequestHeader(value = "num") String opnum)
    { return service.deletecustomer(deleteCustomerDTO,opnum);}
}