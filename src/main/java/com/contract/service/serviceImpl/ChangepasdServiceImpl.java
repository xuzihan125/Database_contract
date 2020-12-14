package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.LogMapper;
import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.dto.LoginDTO;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.entity.User;
import com.contract.mybatis.entity.UserExample;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.ChangepasdService;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class ChangepasdServiceImpl implements ChangepasdService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private LogMapper logMapper;
    @Resource
    private SelectAuthorityTools right;
    @Override
    public RegisterVO checkChangepasd(LoginDTO dto,String opnum) {
        RegisterVO vo = new RegisterVO();
        boolean b=true; //表示有没有权限
        //查权限
        if (!opnum.equals(dto.getNum())) {
            b = right.selectAuthority(opnum,"12");
        }

        //既不是自己也没有权限
        if (!b && !opnum.equals(dto.getNum())) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }

        //自己修改或者有权限进行操作
        else {
            //验证是否为空
            if (dto == null || StringTools.isEmpty(dto.getNum()) || StringTools.isEmpty(dto.getPassword())) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //设置检索条件
            UserExample example = new UserExample();
            example.createCriteria().andUsernumEqualTo(dto.getNum());
            //检索
            List<User> entityList = userMapper.selectByExample(example);
            //修改密码的工号不存在
            if (entityList.isEmpty()) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVALID_CHANGEPASD.getName());
            }
            else {
                User old_user = entityList.get(0); //旧的
                User new_user = new User();
                new_user.setUsernum(dto.getNum());
                new_user.setName(old_user.getName());
                new_user.setPassword(dto.getPassword());
                userMapper.updateByExample(new_user, example);
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                //修改密码写日志
                if(!opnum.equals(dto.getNum())){
                    Log log = new Log();
                    log.setUsernum(opnum);
                    log.setTime(new Date());
                    log.setContent("修改用户密码："+dto.getNum());
                    logMapper.insert(log);
                }
            }
        }
       // b=false; //重置b
        return vo;
    }
}
