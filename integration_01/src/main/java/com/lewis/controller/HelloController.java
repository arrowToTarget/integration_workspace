package com.lewis.controller;

import com.lewis.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by zhangminghua on 2016/3/28.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("name","lewis");
        model.addAttribute("person",new Person(1000,"lewis","male"));
        System.out.println("hello ,i am hello controller");
        return "hello";
    }
}
