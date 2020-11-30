package com.contract.service;

import com.contract.mybatis.dto.ClassDTO;
import com.contract.mybatis.entity.SClass;

import java.util.List;

public interface ClassService {

    List<SClass> GetSelectClass(ClassDTO classDTO);

}
