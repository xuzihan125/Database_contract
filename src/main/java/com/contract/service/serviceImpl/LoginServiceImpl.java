package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.RoleMapper;
import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.entity.Role;
import com.contract.mybatis.entity.RoleExample;
import com.contract.mybatis.entity.User;
import com.contract.mybatis.entity.UserExample;
import com.contract.mybatis.vo.LoginVO;
import com.contract.service.LoginService;
import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;

    @Override
    public LoginVO checkLogin(LoginDTO loginDTO){
        //返回类声明
        LoginVO loginVO = new LoginVO();
        //输入参数验证
        if(loginDTO==null || StringTools.isEmpty(loginDTO.getName()) || StringTools.isEmpty(loginDTO.getPassword())){
            loginVO.setState(false);
            loginVO.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return loginVO;
        }
        //设置检索条件
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(loginDTO.getName()).andPasswordEqualTo(loginDTO.getPassword());
        //检索
        List<User> entityList = userMapper.selectByExample(example);
        //验证登录是否成功
        if(entityList.isEmpty()){
            loginVO.setState(false);
            loginVO.setFeedBack(ErrorCode.INVALID_LOGIN.getName());
            return loginVO;
        }
        //设置返回内容
        User user = entityList.get(0);
        loginVO.setState(true);
        loginVO.setUsernum(user.getUsernum());
        return loginVO;
    }
}
