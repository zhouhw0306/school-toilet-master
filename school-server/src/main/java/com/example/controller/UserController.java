package com.example.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.constant.Result;
import com.example.constant.ResultCode;
import com.example.po.User;
import com.example.service.UserService;
import com.example.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.List;


/**
 * @author zhou
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
    public Result login(String username, String password,String checkCode,HttpSession session){
        Result result = new Result();
        String code = (String)session.getAttribute("checkCode");
        if (!StringUtils.equalsIgnoreCase(code,checkCode)){
            result.setResultCode(ResultCode.USER_CHECK_CODE_ERROR);
            return result;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        List<User> list = userService.list(queryWrapper);
        if (list.size()==0){
            result.setResultCode(ResultCode.USER_LOGIN_ERROR);
            return result;
        }
        User user = list.get(0);
        // 生成token
        String token = JWTUtil.sign(String.valueOf(user.getId()),user.getPassword());
        user.setPassword("it's a secret");
        user.setToken(token);
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(user);
        return result;
    }


    @GetMapping("/api/Code/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(90, 41,4,20);
        String checkCode = lineCaptcha.getCode();
        System.out.println("验证码: "+checkCode);
        session.removeAttribute("checkCode");
        session.setAttribute("checkCode",checkCode);
        //图形验证码写出，可以写出到文件，也可以写出到流
        try {
            lineCaptcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
