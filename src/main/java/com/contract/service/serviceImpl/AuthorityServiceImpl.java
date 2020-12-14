package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.AuthorityMapper;
import com.contract.mybatis.dao.UserMapper;
import com.contract.mybatis.dto.AddAuthoDTO;
import com.contract.mybatis.entity.*;
import com.contract.mybatis.vo.NoneAuthoVO;
import com.contract.service.AuthorityService;
import com.contract.util.copy.ListCopyTool;
import com.contract.util.emnu.EnumCamp;
import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AuthorityServiceImpl implements AuthorityService {
    @Resource
    private AuthorityMapper authorityMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private SelectAuthorityTools right;
    @Override
    public List<NoneAuthoVO> getNoneAutho(String opnum) {
        if(!right.selectAuthority(opnum, EnumCamp.Right.GET_UNAUTHO_USER.getCode())){
            throw  new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
        }
        //获得检索条件
        AuthorityExample example = new AuthorityExample();
        example.createCriteria();
        List<Authority> record = authorityMapper.selectByExample(example);
        List<String> require = new ArrayList<>();
        record.forEach(entity->require.add(entity.getUsernum()));
        //检索条件
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernumNotIn(require);
        List<User> userRecord = userMapper.selectByExample(userExample);
        List<NoneAuthoVO> result = ListCopyTool.copyTo(userRecord,NoneAuthoVO.class);
        return result;
    }

    @Override
    public void addAutho(AddAuthoDTO addAuthoDTO, String opnum){
        if(addAuthoDTO==null|| StringTools.isEmpty(addAuthoDTO.getUserNum()) || StringTools.isEmpty(addAuthoDTO.getRoleName()) || addAuthoDTO.getDesc()==null){
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
        if(!right.selectAuthority(opnum, EnumCamp.Right.ADD_AUTHO.getCode())){
            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
        }
        //验证是否存在
        AuthorityExample example = new AuthorityExample();
        example.createCriteria().andUsernumEqualTo(addAuthoDTO.getUserNum());
        List<Authority> entityList = authorityMapper.selectByExample(example);
        if(entityList.size()>0) {
            throw new ActException(ErrorCode.AUTHO_ALREADY_EXIST.getCode(),ErrorCode.AUTHO_ALREADY_EXIST.getCode());
        }
        //插入数据
        Authority record = new Authority();
        record.setRolename(addAuthoDTO.getRoleName());
        record.setDescription(addAuthoDTO.getDesc());
        record.setUsernum(addAuthoDTO.getUserNum());
        record.setRolenum(addAuthoDTO.getRoleNum());
        authorityMapper.insert(record);
    }

    @Override
    public void setAutho(AddAuthoDTO addAuthoDTO, String opnum){
        if(addAuthoDTO==null|| StringTools.isEmpty(addAuthoDTO.getUserNum()) || StringTools.isEmpty(addAuthoDTO.getRoleName()) || addAuthoDTO.getDesc()==null){
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
        if(!right.selectAuthority(opnum, EnumCamp.Right.SET_AUTHO.getCode())){
            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
        }
        //验证是否存在
        AuthorityExample example = new AuthorityExample();
        example.createCriteria().andUsernumEqualTo(addAuthoDTO.getUserNum());
        List<Authority> entityList = authorityMapper.selectByExample(example);
        if(entityList.size()==0) {
            throw new ActException(ErrorCode.AUTHO_NOT_EXIST.getCode(),ErrorCode.AUTHO_NOT_EXIST.getCode());
        }
        //插入数据
        Authority record = new Authority();
        record.setRolename(addAuthoDTO.getRoleName());
        record.setDescription(addAuthoDTO.getDesc());
        record.setUsernum(addAuthoDTO.getUserNum());
        record.setRolenum(addAuthoDTO.getRoleNum());
        authorityMapper.updateByExample(record,example);
    }

    @Override
    public void delAutho(AddAuthoDTO addAuthoDTO, String opnum){
        if(addAuthoDTO==null|| StringTools.isEmpty(addAuthoDTO.getUserNum()) || StringTools.isEmpty(addAuthoDTO.getRoleName()) || addAuthoDTO.getDesc()==null){
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
        if(!right.selectAuthority(opnum, EnumCamp.Right.SET_AUTHO.getCode())){
            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
        }
        //验证是否存在
        AuthorityExample example = new AuthorityExample();
        example.createCriteria().andUsernumEqualTo(addAuthoDTO.getUserNum());
        int num = authorityMapper.deleteByExample(example);
        if(num==0) {
            throw new ActException(ErrorCode.AUTHO_NOT_EXIST.getCode(),ErrorCode.AUTHO_NOT_EXIST.getCode());
        }
    }
}
