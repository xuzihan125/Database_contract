package com.contract.service;

import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.vo.LoginVO;

public interface LoginService {
    LoginVO checkLogin(LoginDTO loginDTO);
}
