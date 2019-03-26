package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ReportPrivider8005_App {
    public static void main(String[] args) {
        SpringApplication.run(ReportPrivider8005_App.class,args);
    }
}
