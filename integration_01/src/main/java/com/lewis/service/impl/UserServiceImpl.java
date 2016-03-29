package com.lewis.service.impl;

import com.lewis.dao.IUserDao;
import com.lewis.service.IUserService;
import com.lewis.vo.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/29.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public List<User> getAllUsers(User user) {

        return userDao.getAllUsers(user);
    }

    public List<User> queryByName(String name) {
        return userDao.queryByName(name);
    }

    public List<User> queryByHobby(String hobby) {
        return userDao.queryByHobby(hobby);
    }

    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    public void updateById(User user) {
        userDao.updateById(user);
    }
}
