package com.ywj.springlcoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlanPrivider8009_App {
    public static void main(String[] args) {
        SpringApplication.run(PlanPrivider8009_App.class,args);
    }
}
