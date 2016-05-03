package com.lewis.vo;

import com.lewis.util.JsonUtil;

/**
 * Created by zhangminghua on 2016/3/28.
 */
public class Person {
    private int id;
    private String name;

    private String sex;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Person() {
    }

    public Person(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        Person p = new Person(100,"lewis","male");
        System.out.println(JsonUtil.toString(p));
    }
}
