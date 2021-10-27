package com.service;

import com.pojo.User;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/5/5 18:15
 */
public interface UserService {

    List<User> listAll();

    void accountMoney();
}
