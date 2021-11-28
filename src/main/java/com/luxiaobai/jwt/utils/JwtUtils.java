package com.luxiaobai.jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author ：luxiaobai
 * @date ：Created in 2021/11/28 10:13
 * @description： JWT工具类
 * @modified By：`
 * @version: 1.0
 */

public class JwtUtils {
    private static final String SECRECY = "luxiaobai@lsy";

    /**
     * 生成token
     *
     * @param map 传入payload
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 90);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(SECRECY));
    }

    /**
     * 获取token中的payload 验证合法性
     */
    public static DecodedJWT getPayload(String token) {
        return JWT.require(Algorithm.HMAC256(SECRECY)).build().verify(token);
    }
}
