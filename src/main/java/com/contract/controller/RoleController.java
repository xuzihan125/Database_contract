package com.contract.controller;

import com.contract.mybatis.dto.AddRoleDTO;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.vo.ErrorVO;
import com.contract.service.LogService;
import com.contract.service.RoleService;
import com.contract.util.exception.ErrorCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService service;
    //private RegisterService service1;
    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/addRole",method= RequestMethod.GET)
    public ErrorVO addRole(@RequestBody AddRoleDTO addRoleDTO, @RequestHeader(value = "num") String opnum){
       service.addRole(addRoleDTO, opnum);
        return new ErrorVO(true, ErrorCode.SUCCESS.getName());
    }

    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/setRole",method= RequestMethod.GET)
    public ErrorVO setRole(@RequestBody AddRoleDTO addRoleDTO, @RequestHeader(value = "num") String opnum){
        service.modifyRole(addRoleDTO,opnum);
        return new ErrorVO(true,ErrorCode.SUCCESS.getName());
    }
}
