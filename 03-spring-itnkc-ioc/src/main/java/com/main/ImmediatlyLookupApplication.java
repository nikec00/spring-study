package com.main;

import com.bean.Cat;
import com.bean.Dog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description： 延迟查找
 * @Author: nkc
 * @Date: 2021/10/27 10:48
 */
public class ImmediatlyLookupApplication {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Cat bean = context.getBean(Cat.class);
        System.out.println(bean);
        // 如果找不到Dog,不会直接报异常而是将他包装起来
        ObjectProvider<Dog> provider = context.getBeanProvider(Dog.class);
        Dog dog = provider.getIfAvailable();// 如果可用则获取dog实例化信息，不可用或找不到则返回null
        if (dog == null){
            dog = new Dog();
        }
        System.out.println(dog);
    }
}
