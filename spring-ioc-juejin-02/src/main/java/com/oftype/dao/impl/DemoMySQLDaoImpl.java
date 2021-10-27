package com.oftype.dao.impl;

import com.oftype.dao.DemoDAO;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 17:24
 */
public class DemoMySQLDaoImpl implements DemoDAO {
    @Override
    public List findAll() {
        return Arrays.asList("mysql","数据库");
    }
}
