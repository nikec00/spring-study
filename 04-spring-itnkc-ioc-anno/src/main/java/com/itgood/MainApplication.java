package com.itgood;

import com.itgood.beans.Person;
import com.itgood.config.QuickStartConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description： 注解驱动ioc
 * @Author: nkc
 * @Date: 2021/10/27 16:25
 */
public class MainApplication {
    public static void main(String[] args) {
        // 通过注解驱动扫描组件
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(QuickStartConfiguration.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        // 通过xml扫描注解驱动
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person p = context.getBean(Person.class);
        System.out.println(p);

        // 查询所有bean的名称
        // 说明添加了@Configuration的类也会被添加到ioc容器中去：原因是因为该注解也被添加了@Compont
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }
}
