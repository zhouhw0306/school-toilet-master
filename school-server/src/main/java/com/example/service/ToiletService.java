package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.po.Toilet;

import java.util.Map;

public interface ToiletService extends IService<Toilet>{

    Map<String,Object>  getDataByTu2();

}
