package com.itnkc.oauth.entity;

import lombok.Data;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/1 19:12
 */
@Data
public class User {

    private Integer id;

    private String social_uid;

    private String access_token;

    private String remind_in;

    private String expires_in;

    private String username;

    private String password;

    private String phone;

    private String gender;

    private String nikeName;
}
