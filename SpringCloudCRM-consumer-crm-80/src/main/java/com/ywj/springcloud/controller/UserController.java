package com.ywj.springcloud.controller;


import com.ywj.springcloud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName UserController
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 15:51
 */
@RestController
public class UserController {
    private static  final String REST_URL_PREFIX="http://SPRINGCLOUDCRM-LOGIN";
//private static  final String REST_URL_PREFIX="http://localhost:8002";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/login")
    public User loadUserLogin(User user){
        return restTemplate.getForObject(REST_URL_PREFIX+"/login?usr_name="+user.getUsr_name()+"&usr_password="+user.getUsr_password(),User.class);
    }

}
