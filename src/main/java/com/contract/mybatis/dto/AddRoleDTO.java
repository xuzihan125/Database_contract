package com.contract.mybatis.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddRoleDTO {
    private String roleName;
    private String description;
    private List<String> function;
}
