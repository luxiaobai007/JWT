package com.luxiaobai.jwt.service.impl;

import com.luxiaobai.jwt.dao.UserDAO;
import com.luxiaobai.jwt.entity.User;
import com.luxiaobai.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：luxiaobai
 * @date ：Created in 2021/11/28 11:13
 * @description：
 * @modified By：`
 * @version: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDb = userDAO.login(user);
        if (userDb != null) {
            return userDb;
        }
        throw new RuntimeException("登录失败～");
    }
}
