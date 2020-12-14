package com.contract.controller;

import com.contract.mybatis.dto.UsertoContractDTO;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.DistributionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

@RestController(value = "/distribution")
public class DistributionController {
    @Resource
    private DistributionService service;

    @ApiOperation(value = "方法描述:分配合同给操作员,请求方式:Request,参数:,返回值:,是否可用:ok")
    @RequestMapping(value="/distributioncontract",method= RequestMethod.GET)
    public RegisterVO usertocontract(@RequestBody UsertoContractDTO dto, @RequestHeader(value = "num") String opnum) throws ParseException { return service.usertocontract(dto,opnum);}
}