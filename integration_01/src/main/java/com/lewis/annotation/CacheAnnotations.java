package com.lewis.annotation;

import com.lewis.vo.ResponseVo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangminghua on 2016/3/29.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheAnnotations {

    String name();

    int expireTime();

    String returnAddress() default "";

    Class returnObjectType() default ResponseVo.class;
}
