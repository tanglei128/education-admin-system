package com.tyy.educationadminsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.tyy.educationadminsystem.mapper")
@SpringBootApplication
public class EducationAdminSystemApp {

    public static void main(String[] args) {
        SpringApplication.run(EducationAdminSystemApp.class, args);
    }

}
