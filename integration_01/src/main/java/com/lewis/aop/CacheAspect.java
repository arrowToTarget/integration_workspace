package com.lewis.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by zhangminghua on 2016/3/29.
 */
public class CacheAspect {

    public Object doSomething(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before invoke ");
        Object proceed = joinPoint.proceed();
        System.out.println("after invoke ");
        return proceed;
    }

}
