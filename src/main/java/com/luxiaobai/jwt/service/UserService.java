package com.luxiaobai.jwt.service;

import com.luxiaobai.jwt.entity.User;

/**
 * @author ：luxiaobai
 * @date ：Created in 2021/11/28 11:12
 * @description：
 * @modified By：`
 * @version: 1.0
 */
public interface UserService {
    User login(User user);
}
