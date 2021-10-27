package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/5/4 23:39
 */
@Component
@Aspect
public class UserProxy {

//    @Before(value = "execution(* com.dao.User.show(..))")
    public void before(){
        System.out.println("前置通知");
    }

}
