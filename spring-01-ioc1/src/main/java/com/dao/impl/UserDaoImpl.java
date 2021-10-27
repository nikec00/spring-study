package com.dao.impl;

import com.dao.UserDao;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 11:59
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("获取用户数据");
    }
}
