package com.service;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/7 11:14
 */
@Component(value = "userService")
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void serviceTest() {
        userDao.userTest();
        System.out.println("userService测试");
    }
}
