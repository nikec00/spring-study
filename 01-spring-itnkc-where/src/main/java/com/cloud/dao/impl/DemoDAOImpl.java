package com.cloud.dao.impl;

import com.cloud.dao.DemoDAO;

import java.util.Arrays;
import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 14:23
 */
public class DemoDAOImpl implements DemoDAO {
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
