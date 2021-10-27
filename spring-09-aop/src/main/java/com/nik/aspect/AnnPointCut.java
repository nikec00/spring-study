package com.nik.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 13:28
 */
//标注这个类是一个切面
@Aspect
//是一个组件bean交给spring容器去管理 ，xml中需要开启对其的注解支持
@Component
public class AnnPointCut {

    private static final String pointCut = "execution(* com.nik.com.service.UserServiceImpl.*(..))";

    @Before(pointCut)
    public void before() {
        System.out.println("方法执行前");
    }

    @After(pointCut)
    public void after() {
        System.out.println("方法执行之后");
    }

    @Around(pointCut)
    public void around(ProceedingJoinPoint jp) throws Throwable {
        String signature = jp.getSignature().getName();
        System.out.println("环绕前,执行" + signature + "方法");
        //执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后,执行" + signature + "方法");
    }

    @AfterReturning(pointCut)
    public void afterReturn() {
        System.out.println("afterReturn");
    }

}
