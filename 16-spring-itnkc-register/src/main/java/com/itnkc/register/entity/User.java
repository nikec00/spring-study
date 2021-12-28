package com.itnkc.register.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/28 10:13
 */
@Data
@ToString
public class User {

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String code;
}
