package com.luxiaobai.jwt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：luxiaobai
 * @date ：Created in 2021/11/28 11:00
 * @description：
 * @modified By：`
 * @version: 1.0
 */

@Data
@Accessors(chain = true)
public class User {
    private String id;
    private String name;
    private String password;
}
