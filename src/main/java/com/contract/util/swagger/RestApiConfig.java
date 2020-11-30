package com.contract.util.swagger;

import com.contract.util.message.JsonMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建人:张思远
 * 日期: 2020/5/27 上午10:22
 * 描述：swagger 接口扫描
 */
@Configuration
@EnableSwagger2
//@PropertySource("classpath:application.properties")
public class RestApiConfig {

//    @Value("${swagger.enable}")
//    private boolean enableSwagger;

    @Bean
    public Docket createClassApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.contract.controller.test"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("")
                .enable(true)
                .globalOperationParameters(SwaggerUtil.builder())
                .genericModelSubstitutes(JsonMessage.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .groupName("test:演示接口")
                .apiInfo(SwaggerUtil.apiInfo());
    }
}