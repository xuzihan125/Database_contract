package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.RoleMapper;
import com.contract.mybatis.dto.AddRoleDTO;
import com.contract.mybatis.entity.Role;
import com.contract.mybatis.entity.RoleExample;
import com.contract.service.RoleService;
import com.contract.util.emnu.EnumCamp;
import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private SelectAuthorityTools right;
    public void addRole(AddRoleDTO addRoleDTO, String opnum){
        //参数效验
        if(addRoleDTO==null|| StringTools.isEmpty(addRoleDTO.getRoleName())||addRoleDTO.getFunction()==null||addRoleDTO.getFunction().size()==0){
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
        if(!right.selectAuthority(opnum, EnumCamp.Right.ADD_ROLE.getCode())){
            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
        }
        //验证是否存在
        RoleExample example = new RoleExample();
        example.createCriteria().andNameEqualTo(addRoleDTO.getRoleName());
        List<Role> entityList = roleMapper.selectByExample(example);
        Role record = new Role();
        if(entityList.size()>0){
            throw new ActException(ErrorCode.ROLE_ALREADY_EXIST.getCode(),ErrorCode.ROLE_ALREADY_EXIST.getCode());
        }
        //插入数据
        record.setName(addRoleDTO.getRoleName());
        record.setDescription(addRoleDTO.getDescription());
        String tempo = addRoleDTO.getFunction().get(0);
        for(int i=1;i<addRoleDTO.getFunction().size();i++){
            tempo += "#"+addRoleDTO.getFunction().get(i);
        }
        roleMapper.insert(record);
        record.setFunctions(tempo);

    }

    @Override
    public void modifyRole(AddRoleDTO addRoleDTO, String opnum){
        //参数验证
        if(addRoleDTO==null|| StringTools.isEmpty(addRoleDTO.getRoleName())||addRoleDTO.getFunction()==null||addRoleDTO.getFunction().size()==0){
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
        if(!right.selectAuthority(opnum, EnumCamp.Right.MODIFY_ROLE.getCode())){
            throw  new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
        }
        //验证是否存在
        RoleExample example = new RoleExample();
        example.createCriteria().andNameEqualTo(addRoleDTO.getRoleName());
        List<Role> entityList = roleMapper.selectByExample(example);
        if(entityList.size()==0){
            throw new ActException(ErrorCode.ROLE_NOT_EXIST.getCode(),ErrorCode.ROLE_NOT_EXIST.getCode());
        }
        //修改
        Role record = new Role();
        record.setName(addRoleDTO.getRoleName());
        record.setDescription(addRoleDTO.getDescription());
        String tempo = addRoleDTO.getFunction().get(0);
        for(int i=1;i<addRoleDTO.getFunction().size();i++){
            tempo += "#"+addRoleDTO.getFunction().get(i);
        }
        record.setFunctions(tempo);
        roleMapper.updateByExample(record,example);
    }
}
