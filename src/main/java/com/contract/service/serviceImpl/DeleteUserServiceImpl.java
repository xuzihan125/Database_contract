package com.contract.service.serviceImpl;
import com.contract.mybatis.dao.CustomerMapper;
import com.contract.mybatis.dao.LogMapper;
import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.dto.DeleteCustomerDTO;
import com.contract.mybatis.dto.DeleteUserDTO;
import com.contract.mybatis.entity.*;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.DeleteUserService;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private LogMapper logMapper;
    @Resource
    private SelectAuthorityTools right;
//---------------------------------------删除用户------------------------------------->
    @Override
    public RegisterVO deleteuser(DeleteUserDTO dto, String opnum) {
        RegisterVO vo = new RegisterVO();
        //查权限
        boolean b=right.selectAuthority(opnum,"15");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        else {
            //验证是否为空
            if (dto == null || StringTools.isEmpty(dto.getNum())) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //设置检索条件
            UserExample example = new UserExample();
            example.createCriteria().andUsernumEqualTo(dto.getNum());
            //检索
            List<User> entityList = userMapper.selectByExample(example);
            //想要删除的工号不存在
            if (entityList.isEmpty()) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVALID_CHANGEPASD.getName());
            } else {
                userMapper.deleteByPrimaryKey(dto.getNum());
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                //写日志
                Log log = new Log();
                log.setUsernum(opnum);
                log.setTime(new Date());
                log.setContent("删除用户：" + dto.getNum());
                logMapper.insert(log);
            }
        }
        return vo;
    }

//---------------------------------------删除客户------------------------------------->
    @Override
    public RegisterVO deletecustomer(DeleteCustomerDTO dto, String opnum) {
        RegisterVO vo = new RegisterVO();
        //查权限

        boolean b= right.selectAuthority(opnum,"28");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        else {
            //验证是否为空
            if (dto == null || StringTools.isEmpty(dto.getName())||StringTools.isEmpty(dto.getPhone())) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //设置检索条件
            CustomerExample example = new CustomerExample();
            example.createCriteria().andNameEqualTo(dto.getName()).andTelEqualTo(dto.getPhone());
            //检索
            List<Customer> entityList = customerMapper.selectByExample(example);
            //想要删除的客户不存在
            if (entityList.isEmpty()) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVLID_DELETECUSTOMER.getName());
            }
            //可以删除
            else {
                customerMapper.deleteByExample(example);
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                //写日志
                Log log = new Log();
                log.setUsernum(opnum);
                log.setTime(new Date());
                log.setContent("删除客户：" + dto.getName());
                logMapper.insert(log);
            }
        }
        return vo;
    }
}
