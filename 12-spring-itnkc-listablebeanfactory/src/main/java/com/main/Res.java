package com.main;

import com.bean.Cat;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/10 16:07
 */
public class Res {
    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("bean.xml");
        Cat cat = (Cat) context.getBean("cat");
        System.out.println(cat);

    }
}
