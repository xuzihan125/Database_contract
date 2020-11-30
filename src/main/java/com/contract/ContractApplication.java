package com.contract;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.annotation.ServletSecurity;

//@ComponentScan(basePackages = {"com.contract.mybatis.mapper"})
@SpringBootApplication
@MapperScan("com.contract.mybatis.dao")
@EnableConfigurationProperties
@ServletComponentScan
public class ContractApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractApplication.class, args);
    }

}
