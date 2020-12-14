package com.contract.service;

import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.vo.LoginVO;
import com.contract.mybatis.vo.RegisterVO;

public interface ChangepasdService {
    RegisterVO checkChangepasd(LoginDTO dto,String opnum);
}
