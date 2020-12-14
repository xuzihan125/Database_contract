package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.CustomerMapper;
import com.contract.mybatis.dao.LogMapper;
import com.contract.mybatis.dto.ChangeCustomerDTO;
import com.contract.mybatis.entity.Customer;
import com.contract.mybatis.entity.CustomerExample;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.ChangeService;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ChangeAuthorityImpl implements ChangeService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private LogMapper logMapper;
    @Resource
    private SelectAuthorityTools right;
    @Override
    public RegisterVO changecustomer(ChangeCustomerDTO dto, String opnum) {
        RegisterVO vo = new RegisterVO();
        //查权限
        boolean b=true;
        right.selectAuthority(opnum,"25");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        else {
            //验证是否为空
            if (dto == null || dto.getName().get(0).isEmpty()||dto.getName().get(1).isEmpty()||dto.getPhone().get(0).isEmpty()
            ||dto.getPhone().get(1).isEmpty()||StringTools.isEmpty(dto.getAddress())) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }

            CustomerExample example = new CustomerExample();
            example.createCriteria().andNameEqualTo(dto.getName().get(0)).andTelEqualTo(dto.getPhone().get(0));
            //检索
            List<Customer> entityList = customerMapper.selectByExample(example);
            //想要修改的客户存在，可以修改该客户
            if (!entityList.isEmpty()) {
                Customer customer=new Customer();
                customer.setName(dto.getName().get(1));
                customer.setTel(dto.getPhone().get(1));
                customer.setAddress(dto.getAddress());
                customer.setFax(dto.getFax());
                customer.setCode(dto.getCode());
                customer.setBank(dto.getBank());
                customer.setAccount(dto.getAccount());
                customer.setNum(entityList.get(0).getNum());
                customerMapper.updateByExample(customer,example);
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                //写日志
                Log log = new Log();
                log.setUsernum(opnum);
                log.setTime(new Date());
                log.setContent("添加客户：" + dto.getName());
                logMapper.insert(log);
            }
            else {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVLID_DELETECUSTOMER.getName());
            }
        }
        return vo;
    }
}
