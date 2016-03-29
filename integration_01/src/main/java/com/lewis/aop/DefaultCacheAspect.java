package com.lewis.aop;

import com.lewis.annotation.CacheAnnotations;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by zhangminghua on 2016/3/29.
 */
@Aspect
public class DefaultCacheAspect {


    @Around(value= "@annotation(com.lewis.annotation.CacheAnnotations)")
    public Object defaultCahceMethod() throws Throwable {
 /*       String name = cacheAnnotations.name();
        int expire = cacheAnnotations.expireTime();
        System.out.println("name="+name);
        System.out.println("expire="+expire);
        Object[] args = joinPoint.getArgs();*/
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++");
        /*System.out.println(Arrays.toString(args));*/
        return null;
    }
}
