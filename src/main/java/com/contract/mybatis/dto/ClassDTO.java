package com.contract.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClassDTO {
    @ApiModelProperty(value = "检索班级编号列表")
    private List<String> codeList;

    public List<String> getCodeList(){return codeList;}

}
