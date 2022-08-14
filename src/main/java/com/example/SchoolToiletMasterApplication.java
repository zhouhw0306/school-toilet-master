package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhou
 */
@SpringBootApplication
@MapperScan("com/example/mappers")
public class SchoolToiletMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolToiletMasterApplication.class, args);
    }


}
