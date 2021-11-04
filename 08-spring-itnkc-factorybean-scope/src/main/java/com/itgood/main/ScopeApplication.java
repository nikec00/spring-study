package com.itgood.main;

import com.itgood.bean.Tom;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/4 10:36
 */
public class ScopeApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.itgood.configuration");
        Tom bean = applicationContext.getBean(Tom.class);
        System.out.println(bean);
//        Tom bean1 = (Tom) applicationContext.getBean("tom2");
//        System.out.println(bean1);
    }
}
