package com.dao.impl;

import com.dao.TestDao;
import com.pojo.TestA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/15 17:02
 */
@Component
public class TestDaoImpl implements TestDao {

    @Autowired
    TestA testA;

    @Override
    public void testDao() {
        System.out.println(testA.getName() + testA.getHobby());
    }
}
