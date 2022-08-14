package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.po.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhou
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
    public Map login(String username,String password){
        Map<String,Object> map = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        List<User> list = userService.list(queryWrapper);
        if (list.size()==0){
            map.put("code",0);
            return map;
        }
        map.put("code",1);
        return map;
    }

}
