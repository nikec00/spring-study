package com.service.impl;

import com.dao.UserDao;
import com.service.UserService;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 12:00
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void UserService() {
        userDao.getUser();
    }
}
