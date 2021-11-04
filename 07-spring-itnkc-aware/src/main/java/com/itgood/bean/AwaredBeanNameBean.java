package com.itgood.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.NamedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/1 15:10
 */
public class AwaredBeanNameBean implements ApplicationContextAware, BeanNameAware, NamedBean {

    private String beanName;

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
