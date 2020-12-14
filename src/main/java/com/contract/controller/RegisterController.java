package com.contract.controller;

import com.contract.mybatis.dto.RegisterDTO;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.RegisterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
    @Resource
    private RegisterService service;
    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    //@RequestMapping(method= RequestMethod.GET)
    @RequestMapping(value="/checkRegister",method= RequestMethod.GET)
    public RegisterVO checkRegister(@RequestBody RegisterDTO registerDTO,@RequestHeader(value = "num") String opnum)
    { return service.checkRegister(registerDTO,opnum);}
}