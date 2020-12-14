package com.contract.controller;

import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.vo.LoginVO;
import com.contract.service.LoginService;
import com.contract.util.BaseAction.BaseAction;
import com.contract.util.message.JsonMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LoginController extends BaseAction {
    @Resource
    private LoginService service;
    //private RegisterService service1;
    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="login/checkLogin",method= RequestMethod.GET)
    public LoginVO checkLogin(@RequestBody LoginDTO loginDTO,@RequestHeader(value = "num") String opnum){
        return  service.checkLogin(loginDTO,opnum);
    }
}