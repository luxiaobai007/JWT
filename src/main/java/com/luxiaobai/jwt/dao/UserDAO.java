package com.luxiaobai.jwt.dao;

import com.luxiaobai.jwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：luxiaobai
 * @date ：Created in 2021/11/28 11:01
 * @description：
 * @modified By：`
 * @version: 1.0
 */
@Mapper
public interface UserDAO {
    User login(User user);
}
