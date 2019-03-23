package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName Zuul_9527_StartSpringCloudApp
 * @Author ywj
 * @Describe
 * @Date 2019/3/22 0022 11:31
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {
    public static void main(String[] args) {
            SpringApplication.run(Zuul_9527_StartSpringCloudApp.class,args);
    }
}
