package com;

import com.bean.Person;
import com.bean.User;
import com.oftype.dao.DemoDAO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 16:15
 */
public class QuickstartByNameApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Map<String, DemoDAO> beans = context.getBeansOfType(DemoDAO.class);
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean.toString());
        });
    }
}
