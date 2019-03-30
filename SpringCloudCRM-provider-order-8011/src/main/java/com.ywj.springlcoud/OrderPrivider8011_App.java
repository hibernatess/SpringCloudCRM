package com.ywj.springlcoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderPrivider8011_App {
    public static void main(String[] args) {
        SpringApplication.run(OrderPrivider8011_App.class,args);
    }
}
