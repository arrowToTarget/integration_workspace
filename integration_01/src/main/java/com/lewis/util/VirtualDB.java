package com.lewis.util;

import com.lewis.vo.Person;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangminghua on 2016/4/11.
 */
public class VirtualDB {

    private static List<Person> personList = new LinkedList<Person>();

    static {
        personList.add(new Person(001,"lewis001","male"));
        personList.add(new Person(002,"lewis002","male"));
        personList.add(new Person(003,"lewis003","male"));
        personList.add(new Person(004,"lewis004","male"));
        personList.add(new Person(005,"lewis005","male"));
        personList.add(new Person(006,"lewis006","male"));
        personList.add(new Person(007,"lewis007","male"));
    }

    public static List<Person> getPersonList(){
        return personList;
    }

    public void addPerson(Person person){
        personList.add(person);
    }


}
