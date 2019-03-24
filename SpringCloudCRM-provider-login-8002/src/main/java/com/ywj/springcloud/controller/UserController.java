package com.ywj.springcloud.controller;

import com.ywj.springcloud.entities.User;
import com.ywj.springcloud.service.UserService;
import com.ywj.springcloud.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author ywj
 * @Describe
 * @@Date 2019/3/24 0024 14:20
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public User   loadUserLogin(User user){
        return userService.loadUserLogin(user);
    }

}
