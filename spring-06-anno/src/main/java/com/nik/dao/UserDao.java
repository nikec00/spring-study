package com.nik.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 21:25
 */
@Repository
@Qualifier("userDao")
public interface UserDao {

    void getUsr();
}
