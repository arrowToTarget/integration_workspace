package com.lewis.controller;

import com.lewis.annotation.CacheAnnotations;
import com.lewis.service.ICacheService;
import com.lewis.util.VirtualDB;
import com.lewis.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zhangminghua on 2016/3/28.
 */
@Controller
public class HelloController {

    @Resource
    private ICacheService cacheService;

    @RequestMapping("/hello")
    @CacheAnnotations(name = "allPersons" ,expireTime=600,returnAddress = "hello")
    public String sayHello(Model model){
        List<Person> personList = VirtualDB.getPersonList();
        model.addAttribute("personList",personList);
        return "hello";
    }

    @RequestMapping(value = "/add")
    public String add(){
        List<Person> personList = VirtualDB.getPersonList();
        int index = personList.size()+1;
        Person newPer = new Person(index,"lewis_"+index,"male");
        cacheService.lpush("personList",600,Person.class,newPer);
        return "redirect:/hello";
    }
}
