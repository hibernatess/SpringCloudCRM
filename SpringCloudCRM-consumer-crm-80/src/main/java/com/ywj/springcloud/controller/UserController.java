package com.ywj.springcloud.controller;


import com.ywj.springcloud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName UserController
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 15:51
 */
@Controller
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/login")
    public User loadUserLogin(User user){
        return restTemplate.getForObject("",User.class);
    }

}
