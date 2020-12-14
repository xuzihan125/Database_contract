package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.AuthorityMapper;
import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.entity.Authority;
import com.contract.mybatis.entity.AuthorityExample;
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

@SuppressWarnings("ALL")
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private AuthorityMapper authorityMapper;
    @Override
    public LoginVO checkLogin(LoginDTO loginDTO, String opnum) {
        LoginVO loginVO = new LoginVO();
        //验证是否为空
        if (loginDTO == null || StringTools.isEmpty(loginDTO.getNum()) || StringTools.isEmpty(loginDTO.getPassword())) {
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
        //设置检索条件
        UserExample example = new UserExample();
        example.createCriteria().andUsernumEqualTo(loginDTO.getNum()).andPasswordEqualTo(loginDTO.getPassword());
        //检索
        List<User> entityList = userMapper.selectByExample(example);
        //验证登录是否成功
        if (entityList.isEmpty()) {
            throw new ActException(ErrorCode.INVALID_LOGIN.getCode(),ErrorCode.INVALID_LOGIN.getName());
        }
        else {
            User user = entityList.get(0);
            loginVO.setState(true);
            loginVO.setName(user.getName());
            //查权限
            AuthorityExample example1;
            example1 = new AuthorityExample();
            example1.createCriteria().andUsernumEqualTo(loginDTO.getNum());
            List<Authority> entityList_1 = authorityMapper.selectByExample(example1);
            //没权限
            if (entityList_1.isEmpty()) {
                loginVO.setRole(null);
            }
            //有权限
            else {
                Authority right = entityList_1.get(0);
                loginVO.setRole(right.getDescription());
            }
        }
        return loginVO;
    }
}
