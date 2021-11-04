package com.itgood.main;

import com.itgood.abstracts.Toy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/4 10:25
 */
public class BeanTypeApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Toy bean = context.getBean(Toy.class);
        System.out.println(bean);
    }
}
