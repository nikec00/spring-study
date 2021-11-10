package com.main;

import com.bean.Dog;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/10 14:05
 */
public class TestMain {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(classPathResource);
        System.out.println("加载xml文件后容器中的所有bean：");
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        // 测试手动注册 结果：手动注册进IOC容器的bean不会被ListableBeanFactory所获取
        beanFactory.registerSingleton("dog",new Dog());
        System.out.println("手动注册单实例Bean后容器中的所有Bean：");
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        // 查看dog bean是否注册进ioc容器中
        System.out.println(beanFactory.getBean("dog"));

        // 通过getBeanNamesOfType查找
        String[] names = beanFactory.getBeanNamesForType(Dog.class);
        System.out.println(Arrays.asList(names));

        // 当前bean定义的对象个数
        System.out.println(beanFactory.getBeanDefinitionCount());
        // 是否包含
        boolean dog = beanFactory.containsBeanDefinition("dog");

    }
}
