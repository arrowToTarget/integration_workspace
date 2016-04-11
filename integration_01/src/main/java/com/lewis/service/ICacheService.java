package com.lewis.service;

import java.util.List;

/**
 * Created by zhangminghua on 2016/3/30.
 */
public interface ICacheService {

    <T> T getCache(String key,Class<T> type);

    <T> List<T> getListCache(String key, Class<T> type);

    void setCache(String key,Object value,int expireTime);

    void delCache(String key);

    void lpush(String key, int expireTime,List values);

    void rpush(String key, int expireTime,List values);

    void lpush(String key, int expireTime,Class<?> type, Object... values);

    void rpush(String key, int expireTime,Class<?> type,Object... values);

    <T> List<T> getListValueAll(String key,Class<T> type);

    <T> List<T> getListValueRange(String key,int beginIdx,int endIdx,Class<T> type);
}
