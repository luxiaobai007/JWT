package com.luxiaobai.jwt.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.luxiaobai.jwt.entity.User;
import com.luxiaobai.jwt.service.impl.UserServiceImpl;
import com.luxiaobai.jwt.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：luxiaobai
 * @date ：Created in 2021/11/28 10:59
 * @description：
 * @modified By：`
 * @version: 1.0
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user/login")
    public Map<String, Object> login(User user) {
        log.info(("用户名[{}]" + user.getName()));
        log.info("密码[{}]" + user.getPassword());
        Map<String, Object> map = new HashMap<>();
        try {
            User userDb = userService.login(user);
            //生成令牌
            Map<String, String> payload = new HashMap<>();
            payload.put("userId", userDb.getId());
            payload.put("userName", userDb.getName());
            String token = JwtUtils.getToken(payload);
            map.put("token", token);
            map.put("state", true);
            map.put("msg", "认证成功");
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String, Object> test(HttpServletRequest request) {
        String token = request.getHeader("token");
        log.info("token:[{}]", token);
        DecodedJWT payload = JwtUtils.getPayload(token);
        log.info("用户ID:[{}]", payload.getClaim("userId"));
        log.info("用户名:[{}]", payload.getClaim("userName"));
        Map<String, Object> map = new HashMap<>();
        //转换为拦截器  实际业务逻辑
//        try {
//            //验证令牌
//            DecodedJWT payload = JwtUtils.getPayload(token);
//            map.put("state", true);
//            map.put("msg", "认证成功");
//            return map;
//        } catch (TokenExpiredException e) {
//            e.printStackTrace();
//            map.put("msg", "token过期");
//        } catch (AlgorithmMismatchException e) {
//            e.printStackTrace();
//            map.put("msg", "算法不一致！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("msg", "token无效");
//        }
        map.put("state", true);
        return map;
    }
}
