package com.contract.service;

import com.contract.mybatis.dto.RegisterDTO;
import com.contract.mybatis.vo.RegisterVO;

public interface RegisterService {
    RegisterVO checkRegister(RegisterDTO registerDTO);
}
