package com.contract.service;

import com.contract.mybatis.dto.AddAuthoDTO;
import com.contract.mybatis.vo.NoneAuthoVO;

import java.util.List;

public interface AuthorityService {
    List<NoneAuthoVO> getNoneAutho(String opnum);

    void addAutho(AddAuthoDTO addAuthoDTO, String opnum);

    void setAutho(AddAuthoDTO addAuthoDTO, String opnum);

    void delAutho(AddAuthoDTO addAuthoDTO, String opnum);
}
