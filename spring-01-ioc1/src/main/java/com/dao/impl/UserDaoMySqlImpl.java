package com.dao.impl;

import com.dao.UserDao;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 12:04
 */
public class UserDaoMySqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql实现");
    }
}
