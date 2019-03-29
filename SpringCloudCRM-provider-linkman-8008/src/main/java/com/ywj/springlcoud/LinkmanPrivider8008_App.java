package com.ywj.springlcoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LinkmanPrivider8008_App {
    public static void main(String[] args) {
        SpringApplication.run(LinkmanPrivider8008_App.class,args);
    }
}
