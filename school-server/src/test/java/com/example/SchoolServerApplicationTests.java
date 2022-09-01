package com.example;

import com.example.constant.*;
import com.example.mappers.ToiletMapper;
import com.example.vo.EchDataOne;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Resource
    ToiletMapper toiletMapper;

    @Test
    void test(){
        Map<String,Map<String,Long>> map1 = toiletMapper.selectMap1();
        Map<String,Map<String,Long>> map2 = toiletMapper.selectMap2();
        System.out.println(map1.get(1).get("count"));
        System.out.println(map2.get(1).get("count"));
        double c1 = (double)map2.get(1).get("count");
        double c2 = (double)map1.get(1).get("count");
        System.out.println("=="+c1/c2);
        System.out.println(map2);
    }
}
