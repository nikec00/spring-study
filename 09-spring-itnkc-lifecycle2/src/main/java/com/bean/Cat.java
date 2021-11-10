package com.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/10 11:24
 */
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("（一）：cat的实例化阶段~~~~~");
    }

    private String name;


    public void init() {
        System.out.println("（五）："  + name + "被初始化了~~~~");
    }
    public void destroy() {
        System.out.println("（七）：" + this.name + "被销毁了~~~~");
    }
    @PostConstruct
    public void open() {
        System.out.println("（三）：" + name + "PostConstruct~!!!被初始化了~~~~");
    }

    @PreDestroy
    public void close() {
        System.out.println("（六）：" + name + "PreDestroy~!!!被销毁了~~~~");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("（二）：" + name + "猫的名字~~~~");
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("（四）：" + name + "InitializingBean~!!!被初始化了~~~~");
    }
}
