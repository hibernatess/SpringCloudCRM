package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerProvider8006_App {

    public static void main(String[] args) {
        SpringApplication.run(CustomerProvider8006_App.class,args);
    }

}
