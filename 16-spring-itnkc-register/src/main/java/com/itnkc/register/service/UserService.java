package com.itnkc.register.service;

import com.itnkc.register.entity.User;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/28 10:17
 */
public interface UserService {
    String register(User user);

    String sendSms(String phone);
}
