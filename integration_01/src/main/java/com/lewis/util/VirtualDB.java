package com.lewis.util;

import com.lewis.vo.Person;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangminghua on 2016/4/11.
 */
public class VirtualDB {

    private static List<Person> personList = new LinkedList<Person>();

    private static Map<String,Person> personMap = new HashMap<String, Person>();

    static {
        personList.add(new Person(001,"lewis001","male"));
        personList.add(new Person(002,"lewis002","male"));
        personList.add(new Person(003,"lewis003","male"));
        personList.add(new Person(004,"lewis004","male"));
        personList.add(new Person(005,"lewis005","male"));
        personList.add(new Person(006,"lewis006","male"));
        personList.add(new Person(007,"lewis007","male"));
        personMap.put("lewis001",new Person(001,"lewis001","male"));
        personMap.put("lewis002",new Person(002,"lewis002","male"));
        personMap.put("lewis003",new Person(003,"lewis003","male"));
        personMap.put("lewis004",new Person(004,"lewis004","male"));
        personMap.put("lewis005",new Person(005,"lewis005","male"));
        personMap.put("lewis006",new Person(006,"lewis006","male"));
        personMap.put("lewis007",new Person(007,"lewis007","male"));
    }

    public static Map<String, Person> getPersonMap() {
        return personMap;
    }

    public static void setPersonMap(Map<String, Person> personMap) {
        VirtualDB.personMap = personMap;
    }

    public static List<Person> getPersonList(){
        return personList;
    }

    public void addPerson(Person person){
        personList.add(person);
    }


}
