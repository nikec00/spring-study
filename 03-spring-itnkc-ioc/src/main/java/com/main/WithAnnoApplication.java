package com.main;

import com.d_withanno.Color;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 10:29
 */
public class WithAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Map<String, Object> beans = context.getBeansWithAnnotation(Color.class);
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + ":" + bean.toString());
        });


        String[] names = context.getBeanDefinitionNames();
        Stream.of(names).forEach(System.out::println);
    }
}
