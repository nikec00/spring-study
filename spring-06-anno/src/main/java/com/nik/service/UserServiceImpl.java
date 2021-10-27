package com.nik.service;

import com.nik.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 21:28
 */
@Component
@Scope("prototype")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void getUser() {
        userDao.getUsr();
    }
}
