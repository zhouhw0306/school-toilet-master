package com.example;

import com.example.constant.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchoolServerApplicationTests {


    @Test
    void contextLoads() {
        System.out.println(TpyeEnum.findEnumByCode("1"));
        System.out.println(TpyeEnum.findEnumByName("马桶"));

        System.out.println(StatusEnum.findEnumByCode("0"));
        System.out.println(StatusEnum.findEnumByName("有人"));

        System.out.println(SexEnum.findEnumByCode("0"));
        System.out.println(SexEnum.findEnumByName("男"));

        System.out.println(PlaceNoEnum.findEnumByCode("3"));
        System.out.println(PlaceNoEnum.findEnumByName("致远楼"));

        System.out.println(HealthEnum.findEnumByCode("2"));
        System.out.println(HealthEnum.findEnumByName("一般"));
    }

}
