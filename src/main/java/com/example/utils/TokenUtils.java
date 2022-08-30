package com.example.utils;


import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtils {

    /**
     *  生成token
     */
    public static String genToken(String userId,String sign){
        return JWT.create().withAudience(userId)  //将 user id 保存到token里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),2)) // 2小时后token过期
                .sign(Algorithm.HMAC256(sign));
    }
}
