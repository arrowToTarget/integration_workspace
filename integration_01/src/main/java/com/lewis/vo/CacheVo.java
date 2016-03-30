package com.lewis.vo;


/**
 * Created by zhangminghua on 2016/3/30.
 */
public class CacheVo {

    private String key;

    private Class<?> valueType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Class<?> getValueType() {
        return valueType;
    }

    public void setValueType(Class<?> valueType) {
        this.valueType = valueType;
    }

    public CacheVo(String key,  Class<?> valueType) {
        this.key = key;
        this.valueType = valueType;
    }

    public CacheVo() {
    }

    @Override
    public String toString() {
        return "CacheVo{" +
                "key='" + key + '\'' +
                ", valueType=" + valueType +
                '}';
    }
}
