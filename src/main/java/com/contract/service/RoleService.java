package com.contract.service;

import com.contract.mybatis.dto.AddRoleDTO;

public interface RoleService {
    void addRole(AddRoleDTO addRoleDTO, String opnum);

    void modifyRole(AddRoleDTO addRoleDTO, String opnum);
}
