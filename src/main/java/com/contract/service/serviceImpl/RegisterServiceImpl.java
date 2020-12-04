package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.dto.RegisterDTO;
import com.contract.mybatis.entity.User;
import com.contract.mybatis.entity.UserExample;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.RegisterService;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private UserMapper userMapper;

    @Override
    public RegisterVO checkRegister(RegisterDTO registerDTO){
        //返回类声明
        RegisterVO registerVO = new RegisterVO();
        //检验非空
        if(registerDTO==null || StringTools.isEmpty(registerDTO.getName()) || StringTools.isEmpty(registerDTO.getPassword()) ||StringTools.isEmpty(registerDTO.getName())){
            registerVO.setState(false);
            registerVO.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return registerVO;
        }
        //设置检索条件
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(registerDTO.getNum());
        List<User> entityList = userMapper.selectByExample(example);

        //验证注册是否成功
        if(entityList.isEmpty()){
            User user = new User();
            user.setUsernum(registerDTO.getNum());
            user.setName(registerDTO.getName());
            user.setPassword(registerDTO.getPassword());
            userMapper.insert(user);
            registerVO.setState(true);
            registerVO.setFeedBack(ErrorCode.SUCCESS.getName());
            return registerVO;
        }

        System.out.println("...");
        registerVO.setState(false);
        registerVO.setFeedBack(ErrorCode.INVALID_Registr.getName());
        return registerVO;
    }
}