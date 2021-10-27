package com.nik.dao.impl;

import com.nik.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 21:30
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void getUsr() {
        System.out.println("hahahahasa");
    }
}
