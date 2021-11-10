package com;

import com.bean.Cat;
import com.config.SingletonBeansConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/10 11:29
 */
public class SingletonTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SingletonBeansConfiguration.class);
        Cat cat = applicationContext.getBean(Cat.class);
        System.out.println(cat);
        cat.destroy();
    }
}
