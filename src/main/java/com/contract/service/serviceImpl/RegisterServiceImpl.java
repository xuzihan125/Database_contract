package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.LogMapper;
import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.dto.RegisterDTO;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.entity.User;
import com.contract.mybatis.entity.UserExample;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.RegisterService;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private LogMapper logMapper;

    @Resource
    private SelectAuthorityTools right;

    @Override
    public RegisterVO checkRegister(RegisterDTO registerDTO,String opnum) {
        //返回类声明
        RegisterVO registerVO = new RegisterVO();
        //检验非空
        if (registerDTO == null || StringTools.isEmpty(registerDTO.getNum()) || StringTools.isEmpty(registerDTO.getPassword()) || StringTools.isEmpty(registerDTO.getName())) {
            registerVO.setState(false);
            registerVO.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return registerVO;
        }
        boolean b=true; //表示有没有权限
        //查权限
        if (!opnum.equals(registerDTO.getNum())) {
            b = right.selectAuthority(opnum,"12");
        }

        //既不是注册也没有权限
        if (!b && !opnum.equals(registerDTO.getNum())) {
            registerVO.setState(false);
            registerVO.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }

        //注册或者有权限进行操作
        else {
            //设置检索条件
            UserExample example = new UserExample();
            example.createCriteria().andUsernumEqualTo(registerDTO.getNum());
            List<User> entityList = userMapper.selectByExample(example);

            //可以注册
            if (entityList==null||entityList.isEmpty()) {
                User user = new User();
                user.setUsernum(registerDTO.getNum());
                user.setName(registerDTO.getName());
                user.setPassword(registerDTO.getPassword());
                userMapper.insert(user);
                registerVO.setState(true);
                registerVO.setFeedBack(ErrorCode.SUCCESS.getName());
                //新建用户写日志
                if(!opnum.equals(registerDTO.getNum())){
                    Log log = new Log();
                    log.setUsernum(opnum);
                    log.setTime(new Date());
                    log.setContent("新增用户："+registerDTO.getNum());
                    logMapper.insert(log);
                }
            }
            //不能注册
            else {
                registerVO.setState(false);
                registerVO.setFeedBack(ErrorCode.INVALID_Registr.getName());
            }
        }
        return registerVO;
    }
}