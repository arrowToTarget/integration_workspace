package com.lewis.dao;

import com.lewis.vo.User;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/29.
 */
public interface IUserDao {

    List<User> getAllUsers(User user);

    List<User> queryByName(String name);

    List<User> queryByHobby(String hobby);

    void deleteById(int id);

    void updateById(User user);
}
