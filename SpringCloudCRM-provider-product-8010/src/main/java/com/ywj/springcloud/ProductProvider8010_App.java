package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ChangeProvider8001_App
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 8:40
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductProvider8010_App {

    public static void main(String[] args) {
        SpringApplication.run(ProductProvider8010_App.class,args);
    }

}
