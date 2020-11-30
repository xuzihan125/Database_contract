package com.contract.service.serviceImpl;

import com.contract.mybatis.dto.ClassDTO;
import com.contract.mybatis.entity.SClass;
import com.contract.mybatis.entity.SClassExample;
import com.contract.mybatis.dao.SClassMapper;
import com.contract.service.ClassService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Resource
    private SClassMapper classMapper;

    @Override
    public List<SClass> GetSelectClass(ClassDTO classDTO) {
        SClassExample example = new SClassExample();
        example.createCriteria().andClassnoIn(classDTO.getCodeList());
        List<SClass> entityList = classMapper.selectByExample(example);
        return entityList;
    }
}
