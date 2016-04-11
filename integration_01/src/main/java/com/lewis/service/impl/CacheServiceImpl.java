package com.lewis.service.impl;

import com.lewis.service.ICacheService;
import com.lewis.util.CacheUtil;
import com.lewis.util.JsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/30.
 */
@Component
public class CacheServiceImpl implements ICacheService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CacheUtil cacheUtil;


    public <T> T getCache(String key, Class<T> type) {
        try {
            String cacheStr = cacheUtil.getCache(key);
            if (cacheStr != null && cacheStr.length() > 0) {
                return JsonUtil.toBean(cacheStr,type);
            }
        } catch (Exception e) {
            log.error("getCache error {} {}",e,key);
        }
        return null;
    }

    public <T> List<T> getListCache(String key, Class<T> type) {
        try {
            String cacheStr = cacheUtil.getCache(key);
            if (cacheStr != null && cacheStr.length() > 0) {
               return JsonUtil.toList(cacheStr, type);
            }
        } catch (Exception e) {
            log.error("getListCache error {} {}",e,key);
        }
        return null;
    }

    public void setCache(String key, Object value, int expireTime) {
        try {
            cacheUtil.setCache(key,value,expireTime);
        } catch (Exception e) {
            log.error("setCache error {} {}",e,key);
        }
    }

    public void delCache(String key) {
        try {
            cacheUtil.delCache(key);
        } catch (Exception e) {
            log.error("delCache error {} {}",e,key);
        }
    }

    public void lpush(String key, int expireTime, List values) {
        try {
            List<String> stringValues = new LinkedList<String>();
            if (CollectionUtils.isNotEmpty(values)){
                for (Object obj : values) {
                    if (obj instanceof String) {
                        stringValues.add((String) obj);
                    }else {
                        stringValues.add(JsonUtil.toString(obj));
                    }
                }
                cacheUtil.lpush(key,expireTime,stringValues);
            }
        } catch (Exception e) {
            log.error("lpush error {},{}",key,values.toString());
        }
    }

    public void rpush(String key, int expireTime, List values) {
        try {
            List<String> stringValues = new LinkedList<String>();
            if (CollectionUtils.isNotEmpty(values)){
                for (Object obj : values) {
                    if (obj instanceof String) {
                        stringValues.add((String) obj);
                    }else {
                        stringValues.add(JsonUtil.toString(obj));
                    }
                }
                cacheUtil.rpush(key,expireTime,stringValues);
            }
        } catch (Exception e) {
            log.error("rpush error {},{}",key,values.toString());
        }
    }

    public void lpush(String key, int expireTime, Class<?> type,Object... values) {
        try {
            if (values != null) {
                String[] array = new String[values.length];
                transferObjectToString(type, array, values);
                cacheUtil.lpush(key,expireTime,array);
            }
        } catch (Exception e) {
            log.error("lpush error {},{}",key,values.toString());
        }
    }

    private void transferObjectToString(Class<?> type, String[] array, Object[] values) {
        if (type == String.class) {
            System.arraycopy(values,0,array,0,values.length);
        }else{
            for (int i= 0;i<values.length;i++) {
               array[i] = JsonUtil.toString(values[i]);
            }
        }
    }

    public void rpush(String key, int expireTime,Class<?> type, Object... values) {
        try {
            if (values != null) {
                String[] array = new String[values.length];
                transferObjectToString(type, array, values);
                cacheUtil.rpush(key,expireTime,array);
            }
        } catch (Exception e) {
            log.error("rpush error {},{}",key,values.toString());
        }
    }

    public <T> List<T> getListValueAll(String key, Class<T> type) {
        try {
            List<String> stringValues = cacheUtil.getListStringValueAll(key);
            List<T> retList = new LinkedList<T>();
            if (CollectionUtils.isNotEmpty(stringValues)) {
                for (String str : stringValues) {
                    retList.add(JsonUtil.toBean(str,type));
                }
            }
            return retList;
        } catch (Exception e) {
            log.error("getListValueAll error {},{} ",key,type);
            throw new RuntimeException("getListValueAll getException",e);
        }
    }

    public <T> List<T> getListValueRange(String key, int beginIdx, int endIdx, Class<T> type) {
        try {
            List<String> stringValues = cacheUtil.getListStringValue(key,beginIdx,endIdx);
            List<T> retList = new LinkedList<T>();
            if (CollectionUtils.isNotEmpty(stringValues)) {
                for (String str : stringValues) {
                    retList.add(JsonUtil.toBean(str,type));
                }
            }
            return retList;
        } catch (Exception e) {
            log.error("getListValueAll error {},{} ",key,type);
            throw new RuntimeException("getListValueAll getException",e);
        }
    }
}
