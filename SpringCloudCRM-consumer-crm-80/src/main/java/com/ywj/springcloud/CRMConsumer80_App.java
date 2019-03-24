package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName CRMConsumer80_App
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 10:05
 */
@SpringBootApplication
@EnableEurekaClient
public class CRMConsumer80_App {


    public static void main(String[] args) {
        SpringApplication.run(CRMConsumer80_App.class,args);
    }

}
