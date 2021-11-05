package com.itgood;

import com.itgood.beans.Pen;
import com.itgood.config.BeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/5 09:37
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("准备初始化IOC容器。。。");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        System.out.println("IOC容器初始化完成。。。");
        System.out.println("");
        System.out.println("准备销毁IOC容器。。。");
        applicationContext.close();
        System.out.println("IOC容器销毁完成。。。");

    }
}
