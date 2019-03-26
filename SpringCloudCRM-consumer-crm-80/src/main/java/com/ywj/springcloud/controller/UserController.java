package com.ywj.springcloud.controller;


import com.ywj.springcloud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 15:51
 */
@Controller
public class UserController {
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUDCRM-LOGIN";
    @Autowired
    private RestTemplate restTemplate;
    @ResponseBody
    @RequestMapping("/consumer/login")
    public Boolean loadUserLogin(User user, HttpSession session) {
        User User = restTemplate.getForObject(REST_URL_PREFIX + "/login?usr_name=" + user.getUsr_name() + "&usr_password=" + user.getUsr_password(), User.class);
        if (User != null) {
            session.setAttribute("user",User);
            return true;
        }
        return false;
    }

   @GetMapping("/")
    public String loging(){
        return  "login";
    }

}
