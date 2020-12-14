package com.contract.service;

import com.contract.mybatis.dto.UsertoContractDTO;
import com.contract.mybatis.vo.RegisterVO;

import java.text.ParseException;

public interface DistributionService {
    RegisterVO usertocontract(UsertoContractDTO dto, String opnum) throws ParseException;
}
