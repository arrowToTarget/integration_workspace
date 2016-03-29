package com.lewis.vo;

/**
 * Created by zhangminghua on 2016/3/29.
 */
public class User {
    private int id;

    private String name;

    private String birthday;

    private String hobby;

    public User() {
    }

    public User(int id, String name, String birthday, String hobby) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
