package com.contract.service;

import com.contract.mybatis.dto.*;
import com.contract.mybatis.vo.*;

public interface SelectService {
    //查用户
    SelectUserVO selectuser(SelectUserDTO selectUserDTO, String opnum);
    //查客户
    SelectCustomerVO selectcustomer(SelectCustomerDTO selectCustomerDTO,String opnum);
    //查功能
    SelectFunctionVO selectfunction(SelectFunctionDTO dto,String opnum);
    //查合同
    SelectContractVO selectcontract(SelectContractOrStateDTO dto, String opnum);
    //查权限
    SelectUserVO selectright(SelectRightDTO dto,String opnum);
    //查待**
    SelectContractVO selectcontracttouser(SelectContectToUserDTO dto,String opnum);
    //查看合同具体内容
    SelectContentVO selectcontent(SelectContentDTO dto,String opnum);
}

