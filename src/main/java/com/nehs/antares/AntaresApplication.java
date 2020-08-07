package com.nehs.antares;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.enhs.antares.mapper")
public class AntaresApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntaresApplication.class, args);
    }

}
