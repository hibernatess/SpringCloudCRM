package com.ywj.springcloud.service.impl;

import com.ywj.springcloud.entities.User;
import com.ywj.springcloud.mapper.UserMapper;
import com.ywj.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 14:19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loadUserLogin(User user) {
        return userMapper.loadUserLogin(user);
    }
}
