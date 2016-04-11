package com.lewis.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 将数组插入list的头部（最左端）
     * @param key  list对应的key
     * @param expire 该key的失效时间
     * @param value 待插入的数据
     */
    public void lpush(String key, int expire, String... value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                jedis.lpush(key,value);
            }else{
                jedis.lpush(key,value);
                jedis.expire(key, expire);
            }
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }

    /**
     * 将集合values中的数据插入到list中的头部（最左端）
     * @param key  list对应的key
     * @param expire 该key的失效时间
     * @param values 待插入的数据
     */
    public void lpush(String key,int expire,List<String> values){
        if (values == null || values.isEmpty()) {
            return;
        }
        String[] array = new String[values.size()];
        array = values.toArray(array);
        lpush(key,expire,array);
    }

    /**
     * 将数组插入list的尾部（最右端）
     * @param key  list对应的key
     * @param expire 该key的失效时间
     * @param values 待插入的数据
     */
    public void rpush(String key,int expire,String... values){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                jedis.rpush(key,values);
            }else{
                jedis.rpush(key,values);
                jedis.expire(key,expire);
            }
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }

    /**
     * 将集合values中的数据插入到list中的尾部（最右端）
     * @param key  list对应的key
     * @param expire 该key的失效时间
     * @param values 待插入的数据
     */
    public void rpush(String key,int expire,List<String> values){
        if (values == null || values.isEmpty()) {
            return;
        }
        String[] array = new String[values.size()];
        array = values.toArray(array);
        rpush(key,expire,array);
    }

    /**
     * 从list中弹出第一个元素
     * @param key list 对应的key
     * @return 第一个元素
     */
    public String lpop(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
               return jedis.lpop(key);
            }else{
               return null;
            }
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }

    /**
     * 从list中弹出最后一个元素
     * @param key list 对应的key
     * @return 最后一个元素
     */
    public String rpop(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                return jedis.rpop(key);
            }else{
                return null;
            }
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }

    /**
     * 从list中获取list子集，从beginIndex开始到endIndex
     * @param key list所对应的Key
     * @param beginIndex list中开始的下标
     * @param endIndex list中结束的下标
     * @return list子集，从beginIndex开始到endIndex
     */
    public List<String> getListStringValue(String key,int beginIndex,int endIndex){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.lrange(key,beginIndex,endIndex);
        } catch (Exception e) {
            broken(jedis);
            throw new RuntimeException(e);
        } finally {
            release(jedis);
        }
    }

    public List<String> getListStringValueAll(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.lrange(key,0,-1);
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
