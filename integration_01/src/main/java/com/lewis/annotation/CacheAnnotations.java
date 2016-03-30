package com.lewis.annotation;

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

    Class<?> elementType() default Object.class;

    CollectionType collectionType();

    String returnAddress();
}
