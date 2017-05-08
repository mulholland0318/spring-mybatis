package com.mdachu.service;

import com.mdachu.dao.UserDao;
import com.mdachu.entity.User;
import com.mdachu.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mm on 2017/5/3.
 */
@Service(value = "userService")
public class UserService {

    @Resource(name="userMapper")
    private UserMapper userMapper;


    @Resource(name="userDao")
    private UserDao userDao;

    public int save(User user){
        return userDao.save("UserMapper.save",user);
    }

    public void saveOne(User user){
        userMapper.save(user);
    }

    public User findById(String id){
        return userMapper.findById(id);
    }

    public int edit(User user) {
        return userMapper.edit(user);
    }
}
