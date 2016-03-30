package com.lewis.service;

import java.util.List;

/**
 * Created by zhangminghua on 2016/3/30.
 */
public interface ICacheService {

    <T> T getCache(String key,Class<T> type);

    <T> List<T> getListCache(String key, Class<T> type);

    void setCache(String key,Object value,int expireTime);

}
