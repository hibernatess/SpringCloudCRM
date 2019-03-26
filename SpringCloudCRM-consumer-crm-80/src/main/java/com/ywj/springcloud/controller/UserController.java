package com.ywj.springcloud.controller;


import com.ywj.springcloud.entities.TreeNode;
import com.ywj.springcloud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        User user1 = restTemplate.getForObject(REST_URL_PREFIX + "/login?usr_name=" + user.getUsr_name() + "&usr_password=" + user.getUsr_password(), User.class);
        if (user1 != null) {
            session.setAttribute("user", user1);
            return true;
        }
        return false;
    }
    @ResponseBody
    @RequestMapping("/consumer/menuTreelist")
    public List<TreeNode> menuTreelist(String role_id) {
        List<TreeNode> forObject = restTemplate.getForObject(REST_URL_PREFIX + "/menuTreelist?role_id=" + role_id, List.class);
        return forObject;
    }


    @ResponseBody
    @RequestMapping("/consumer/getUser")
    public User getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user;
    }


}
