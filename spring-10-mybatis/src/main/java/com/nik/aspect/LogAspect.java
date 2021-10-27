package com.nik.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 16:01
 */
//@Component
//@Aspect
public class LogAspect {

    private static final String POINT_CUT = "execution(* com.nik.mapper.*MapperImpl.*(..))";

    @Around(POINT_CUT)
    public void around(ProceedingJoinPoint jp) throws Throwable {
        String name = jp.getSignature().getName();
        System.out.println("[debug]执行了:" + name + "方法");
        jp.proceed();
    }
}
