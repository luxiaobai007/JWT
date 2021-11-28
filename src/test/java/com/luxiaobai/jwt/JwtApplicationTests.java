package com.luxiaobai.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;


class JwtApplicationTests {

    @Test
    void contextLoads() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 90);
        //生成令牌 链式调用
        String token = JWT.create()
                //设置自定义签名
                .withClaim("username", "张三")
                .withClaim("userID", 1)
                //设置过期时间
                .withExpiresAt(instance.getTime())
                //设置签名 保密 复杂
                .sign(Algorithm.HMAC256("token@HDLSDJDKF"));
        System.out.println("输出令牌：" + token);
    }

    @Test
    void checkJWT(){
        //构建验签对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("token@HDLSDJDKF")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MzgwNjUxOTYsInVzZXJJRCI6MSwidXNlcm5hbWUiOiLlvKDkuIkifQ.gNbzYHZsOMyd8rEGyPtTImRFnTQb6dhOa5jMzZq_lL0");
        Claim username = verify.getClaim("username");
        Claim userID = verify.getClaim("userID");
        //注意类型问题，否则拿不到对应的数据为null
        System.out.println(userID.asInt());
        System.out.println(username.asString());
    }

}
