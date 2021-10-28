package com.itgood;

import com.itgood.bean.Cat;
import com.itgood.configurations.ComponentConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/28 17:07
 */
public class TestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.itgood.configuration");
        Cat cat = applicationContext.getBean(Cat.class);
        System.out.println(cat);
    }
}
