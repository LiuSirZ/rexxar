package com.zherke.rexxar.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.zherke.rexxar.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.zherke.rexxar.**")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
