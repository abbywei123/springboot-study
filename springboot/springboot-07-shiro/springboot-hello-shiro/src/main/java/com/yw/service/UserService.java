package com.yw.service;

import com.yw.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User queryBYName(String name);
}
