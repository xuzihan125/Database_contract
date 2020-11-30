package com.contract.util.swagger;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人:张思远
 * 日期: 2020/5/27 上午10:22
 * 描述：
 */
public class SwaggerUtil {

    public static List<Parameter> builder(){
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("Authorization").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .defaultValue("bearer ").build();
        pars.add(tokenPar.build());
        return pars;
    }


    public static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Report")
                .description("金融工具")
                .version("1.0")
                .build();
    }
}