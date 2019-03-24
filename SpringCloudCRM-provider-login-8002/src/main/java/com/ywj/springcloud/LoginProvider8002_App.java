package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName Login
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 8:47
 */
@SpringBootApplication
@EnableEurekaClient
public class LoginProvider8002_App {

    public static void main(String[] args) {
        SpringApplication.run(LoginProvider8002_App.class,args);
    }

}
