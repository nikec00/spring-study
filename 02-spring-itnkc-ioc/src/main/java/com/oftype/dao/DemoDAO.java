package com.oftype.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 17:22
 */
public interface DemoDAO {
    List findAll();

}
