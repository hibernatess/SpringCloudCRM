package com.ywj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName ConfigBean
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 10:06
 */
@Configuration
public class ConfigBean  {
    /**
     * @Description: 用于调用其他服务
     * @Param: []
     * @return: org.springframework.web.client.RestTemplate
     * @Author: ywj
     * @Date: 2019/3/24 0024
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }




}
