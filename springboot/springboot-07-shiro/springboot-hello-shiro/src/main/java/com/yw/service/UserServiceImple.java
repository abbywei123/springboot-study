package com.yw.service;

import com.yw.mapper.UserMapper;
import com.yw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryBYName(String name) {
        return userMapper.queryBYName(name);
    }
}
