package com;

import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;


/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/5/5 18:18
 */
@Component
public class TestUser {


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService iUserDao = context.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(iUserDao.listAll());

    }
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = context.getBean("userServiceImpl", UserServiceImpl.class);

        service.accountMoney();

    }
}
