package com.contract.service;

import com.contract.mybatis.dto.AddContractDTO;
import com.contract.mybatis.dto.AddCustomerDTO;
import com.contract.mybatis.dto.CountersignDTO;
import com.contract.mybatis.vo.RegisterVO;

import java.text.ParseException;

//添加类
public interface AddService {
    //添加客户
    RegisterVO AddCustomer(AddCustomerDTO dto, String opnum);
    //添加合同
    RegisterVO AddContract(AddContractDTO dto,String opnum);
    //添加会签
    RegisterVO AddCountersign(CountersignDTO dto,String opnum) throws ParseException;
}
