package com.contract.controller.login;


import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.vo.LoginVO;
import com.contract.service.LoginService;
import com.contract.util.BaseAction.BaseAction;
import com.contract.util.message.JsonMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController(value = "/login")
public class LoginController {
    @Resource
    private LoginService service;

    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/checkLogin",method= RequestMethod.GET)
    public LoginVO checkLogin(@RequestBody LoginDTO loginDTO){
        return service.checkLogin(loginDTO);
    }
}