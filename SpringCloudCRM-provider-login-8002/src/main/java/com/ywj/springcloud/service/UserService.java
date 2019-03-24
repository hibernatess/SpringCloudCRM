package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.User;

public interface UserService {
    /**    
        *@Description: 用户信息
        * @Param: [user]
        * @return: com.ywj.springcloud.entities.User
        * @Author: ywj
        * @Date: 2019/3/24 0024
        */
    public User loadUserLogin(User user);
}
