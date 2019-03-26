package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName DictProvider8004_APP
 * @Author ywj
 * @Describe
 * @Date 2019/3/26 0026 9:50
 */
@SpringBootApplication
@EnableEurekaClient
public class DictProvider8004_APP {

    public static void main(String[] args) {
        SpringApplication.run(DictProvider8004_APP.class,args);
    }
}
