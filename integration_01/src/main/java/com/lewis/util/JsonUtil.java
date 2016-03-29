package com.lewis.util;

import com.alibaba.fastjson.JSON;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/29.
 */
public class JsonUtil {

    public static String toString(Object obj){
        if (obj instanceof String) {
            return (String)obj;
        }
        return JSON.toJSONString(obj);
    }

    public static <T> T toBean(Object str,Class<T> clazz){
        if (str != null) {
            if (str instanceof String) {
                return JSON.parseObject((String)str, clazz);
            }else {
                return JSON.parseObject(toString(str),clazz);
            }
        }
        return null;
    }

    public static <T> List<T> toList(String str, Class<T> clazz){
        if (str != null && str.length() > 0) {
            List<T> retList = new LinkedList<T>();
            List<Object> list = toBean(str, List.class);
            if (list != null && list.size() > 0) {
                for (Object obj : list) {
                    retList.add(JSON.parseObject(obj.toString(), clazz));
                }
            }
            return retList;
        }
        return null;
    }

}
