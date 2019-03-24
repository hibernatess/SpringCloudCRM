package com.ywj.springlcoud;

import com.ywj.springcloud.entities.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ServerPrivider8003_App {
    public static void main(String[] args) {
        SpringApplication.run(ServerPrivider8003_App.class,args);
    }
}
