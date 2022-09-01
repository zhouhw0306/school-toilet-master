package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mappers.ToiletMapper;
import com.example.po.Toilet;
import com.example.service.ToiletService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ToiletServiceImpl extends ServiceImpl<ToiletMapper,Toilet> implements ToiletService {

    @Resource
    ToiletMapper toiletMapper;

    @Override
    public Map<String,Object> getDataByTu2() {
        Map<String,Map<String,Long>> map1 = toiletMapper.selectMap1();
        Map<String,Map<String,Long>> map2 = toiletMapper.selectMap2();
        Map<String,Object> map = new HashMap<>();

        double c11 = (double)map2.get(1).get("count");
        double c12 = (double)map1.get(1).get("count");
        map.put("a",String.format("%.2f",c11/c12*100));
        double c21 = (double)map2.get(2).get("count");
        double c22 = (double)map1.get(2).get("count");
        map.put("b",String.format("%.2f",c21/c22*100));
        double c31 = (double)map2.get(3).get("count");
        double c32 = (double)map1.get(3).get("count");
        map.put("c",String.format("%.2f",c31/c32*100));
        return map;
    }
}
