package com.itgood.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.stream.Stream;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/1 14:55
 */
public class AwaredTestBean implements ApplicationContextAware, BeanNameAware {


    private String beanName;

    private ApplicationContext context;


    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void printBeanNames() {
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}
