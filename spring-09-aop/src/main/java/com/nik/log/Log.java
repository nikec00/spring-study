package com.nik.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 12:40
 */
public class Log implements MethodBeforeAdvice {
    //method: 要执行的目标方法对象
    //args: 参数
    //target: 目标对象
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
    }
}
