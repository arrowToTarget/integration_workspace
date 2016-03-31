package com.lewis.controller;

import com.lewis.annotation.CacheAnnotations;
import com.lewis.annotation.CollectionType;
import com.lewis.service.IUserService;
import com.lewis.util.CacheUtil;
import com.lewis.util.JsonUtil;
import com.lewis.vo.Person;
import com.lewis.vo.TravelRecord;
import com.lewis.vo.User;
import org.hibernate.ejb.criteria.expression.ListIndexExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangminghua on 2016/3/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/all")
    @CacheAnnotations(name = "allUsers" ,expireTime = 600,returnAddress = "userlist")
    public String queryallUsers(Model model, @RequestParam(value = "name",required = false)String searchName, @RequestParam(value = "hobby",required = false)String hobby){
        User user = new User();
        user.setName(searchName);
        user.setHobby(hobby);
        List<User> users = userService.getAllUsers(user);
        model.addAttribute("users",users);

        List<Person> personList = new LinkedList<Person>();
        personList.add(new Person(100,"lewis","male"));
        personList.add(new Person(101,"lewis1","male"));
        personList.add(new Person(102,"lewis2","male"));
        personList.add(new Person(103,"lewis3","male"));
        model.addAttribute("personList",personList);

        TravelRecord travelRecord = new TravelRecord();
        travelRecord.setId(1000);
        travelRecord.setDays(20);
        travelRecord.setFee(30.50);
        travelRecord.setTravelDate("2016-03-30");
        travelRecord.setUserId(100001);
        model.addAttribute("travelRecord" ,travelRecord);

        Map<String,String> map = new HashMap<String, String>();
        map.put("name","lewis");
        map.put("age ","12");
        map.put("sex","male");
        map.put("hobbby","sing");
        model.addAttribute("map",map);
        return "userlist";
    }



}
