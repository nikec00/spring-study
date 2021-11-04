package com.itgood;

import com.itgood.bean.Dog;
import com.itgood.configuration.AwareConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/1 16:22
 */
public class BeanApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AwareConfiguration.class);
        Dog bean = applicationContext.getBean(Dog.class);
        bean.m1();
    }
}
