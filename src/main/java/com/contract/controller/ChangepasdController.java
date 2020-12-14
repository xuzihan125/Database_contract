package com.contract.controller;

import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.ChangepasdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController(value = "/change1")
public class ChangepasdController {
    @Resource
    private ChangepasdService service;
    @ApiOperation(value = "方法描述:用户登录,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/changePassword",method= RequestMethod.GET)
    public RegisterVO checkChangepasd(@RequestBody LoginDTO dto, @RequestHeader(value = "num") String opnum){
        return service.checkChangepasd(dto,opnum);
    }
}
