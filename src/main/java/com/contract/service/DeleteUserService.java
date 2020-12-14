package com.contract.service;

import com.contract.mybatis.dto.DeleteCustomerDTO;
import com.contract.mybatis.dto.DeleteUserDTO;
import com.contract.mybatis.vo.RegisterVO;

public interface DeleteUserService {
    RegisterVO deleteuser(DeleteUserDTO dto, String opnum);
    RegisterVO deletecustomer(DeleteCustomerDTO dto,String opnum);
}
