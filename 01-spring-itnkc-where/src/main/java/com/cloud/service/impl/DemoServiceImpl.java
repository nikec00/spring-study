package com.cloud.service.impl;

import com.cloud.dao.DemoDAO;
import com.cloud.dao.impl.DemoDAOImpl;
import com.cloud.factory.BeanFactory;
import com.cloud.service.DemoService;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 14:24
 */
public class DemoServiceImpl implements DemoService {

    DemoDAO demoDAO = (DemoDAO)BeanFactory.getDemoDAO("demoDAO");

    @Override
    public List<String> findAll() {
        return this.demoDAO.findAll();
    }
}
