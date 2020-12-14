package com.contract.service;

import com.contract.mybatis.dto.ChangeCustomerDTO;
import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.vo.RegisterVO;

public interface ChangeService {
    RegisterVO changecustomer(ChangeCustomerDTO dto, String opnum);
}
