package com.example.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.po.Toilet;
import org.apache.ibatis.annotations.MapKey;
import java.util.Map;

public interface ToiletMapper extends BaseMapper<Toilet> {

    @MapKey("type")
    Map<String,Map<String,Long>> selectMap1();
    @MapKey("type")
    Map<String,Map<String,Long>>  selectMap2();
}
