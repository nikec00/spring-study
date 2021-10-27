package com.service.impl;

import com.dao.TestDao;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/15 17:03
 */
@Component("testServiceImpl")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
//    public void setTestDao(TestDao testDao) {
//        this.testDao = testDao;
//    }

//    public TestServiceImpl(TestDao testDao) {
//        this.testDao = testDao;
//    }

    @Override
    public void testService() {
        testDao.testDao();
    }
}
