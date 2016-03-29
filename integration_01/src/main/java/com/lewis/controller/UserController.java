package com.lewis.controller;

import com.lewis.annotation.CacheAnnotations;
import com.lewis.service.IUserService;
import com.lewis.util.CacheUtil;
import com.lewis.util.JsonUtil;
import com.lewis.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private CacheUtil cacheUtil;

    @Resource
    private IUserService userService;

    @RequestMapping("/all")
    @CacheAnnotations(name = "allUsers" ,expireTime = 600)
    public String queryallUsers(Model model, @RequestParam(value = "name",required = false)String searchName, @RequestParam(value = "hobby",required = false)String hobby){
        String allUsers = cacheUtil.getCache("allUsers");
        List<User> users = null;
        if (allUsers != null && allUsers.length() > 0) {
            users = JsonUtil.toList(allUsers, User.class);
        }else {
            User user = new User();
            user.setName(searchName);
            user.setHobby(hobby);
            users = userService.getAllUsers(user);
        }
        if (users != null) {
            cacheUtil.setCache("allUsers",users,600);
        }
        model.addAttribute("users",users);
        return "userlist";
    }



}
