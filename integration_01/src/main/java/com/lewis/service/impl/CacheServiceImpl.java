package com.lewis.service.impl;

import com.lewis.service.ICacheService;
import com.lewis.util.CacheUtil;
import com.lewis.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
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
}
