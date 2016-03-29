package com.lewis.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import javax.annotation.Resource;

/**
 * Created by zhangminghua on 2016/3/29.
 */
@Component
public class CacheUtil {

    @Resource
    private JedisPool jedisPool;

    public String getCache(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }

    public void setCache(String key,Object value,int expire){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key,expire,JsonUtil.toString(value));
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }


    public void delCache(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }


    public void release(Jedis jedis){
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    public void broken(Jedis jedis){
        if (jedis != null) {
            jedisPool.returnBrokenResource(jedis);
        }
    }
}
