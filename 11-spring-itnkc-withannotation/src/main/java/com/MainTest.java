package com;

import com.anno.Color;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/9 14:59
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String, Object> beans = context.getBeansWithAnnotation(Color.class);
        beans.forEach((beanName,bean) -> {
            System.out.println("beanName:" + beanName + ", bean:" + bean);
        });
    }
}
