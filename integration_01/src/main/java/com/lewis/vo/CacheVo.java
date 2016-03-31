package com.lewis.vo;


/**
 * Created by zhangminghua on 2016/3/30.
 */
public class CacheVo {

    private String key;

    private Class<?> valueType;

    private Class<?> elementType;

    public Class<?> getElementType() {
        return elementType;
    }

    public void setElementType(Class<?> elementType) {
        this.elementType = elementType;
    }

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

    public CacheVo(String key, Class<?> valueType, Class<?> elementType) {
        this.key = key;
        this.valueType = valueType;
        this.elementType = elementType;
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
