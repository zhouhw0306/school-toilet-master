package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.constant.Result;
import com.example.constant.ResultCode;
import com.example.po.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;


/**
 * @author zhou
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
    public Result login(String username,String password){
        Result result = new Result();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        List<User> list = userService.list(queryWrapper);
        if (list.size()==0){
            result.setResultCode(ResultCode.ERROR);
            return result;
        }
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

}
