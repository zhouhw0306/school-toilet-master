package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mappers.ToiletMapper;
import com.example.po.Toilet;
import com.example.service.ToiletService;
import org.springframework.stereotype.Service;

@Service
public class ToiletServiceImpl extends ServiceImpl<ToiletMapper,Toilet> implements ToiletService {

}
