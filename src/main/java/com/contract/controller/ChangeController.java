package com.contract.controller;

import com.contract.mybatis.dto.ChangeCustomerDTO;
import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.ChangeService;
import com.contract.service.ChangepasdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController(value = "/change")
public class ChangeController {
    @Resource
    private ChangeService service;
    @ApiOperation(value = "方法描述:编辑客户,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/changecustomer",method= RequestMethod.GET)
    public RegisterVO changecustomer(@RequestBody ChangeCustomerDTO dto, @RequestHeader(value = "num") String opnum){
        return service.changecustomer(dto,opnum);
    }
}