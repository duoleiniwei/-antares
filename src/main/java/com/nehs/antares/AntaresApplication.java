package com.nehs.antares;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nehs.antares")
@SpringBootApplication
public class AntaresApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntaresApplication.class, args);
    }

}
