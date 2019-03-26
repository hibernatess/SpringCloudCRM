package com.ywj.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ywj.springcloud.config.ConfigBean;
import com.ywj.springcloud.entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
* @Description:    SpringCloudCRM-provider-server-8003的消费端
* @Author:         hhh
* @CreateDate:
* @UpdateUser:     hhh
* @UpdateDate:
*/
@RestController
@RequestMapping("/server")
public class ServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    public String GetEurekaClient(){
        //去eureka上找SpringCloudCRM-8003
        InstanceInfo eureka = eurekaClient.getNextServerFromEureka("SpringCloudCRM-8003", false);
        //把找到后把取地址
        String homePageUrl = eureka.getHomePageUrl();
        return homePageUrl;
    }


    /**
     * 添加服务（创建服务）
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:31
     */
    @RequestMapping("/addService")
    public int addService(Service service){
        //访问服务层，获取数据
        Integer object = restTemplate.getForObject(GetEurekaClient() + "server/addService?" + service, Integer.class);
        return object;
    }

    @GetMapping("/findAll")
    public List<Service> findServerMultiple(String svr_cust_name,String svr_title,String svr_type,String svr_status,String begindate,String enddate){
        StringBuffer sb=new StringBuffer();
        sb.append("server/findServerMultiple");
        if(!StringUtils.isEmpty(svr_cust_name)){
            sb.append("?svr_cust_name=" + svr_cust_name);
        }
        if(!StringUtils.isEmpty(svr_title)){
            sb.append("&svr_title=" + svr_title);
        }
        if(!StringUtils.isEmpty(svr_type)){
            sb.append("&svr_type=" + svr_type);
        }
        if(!StringUtils.isEmpty(svr_status)){
            sb.append("&svr_status=" + svr_status);
        }
        if(!StringUtils.isEmpty(begindate)){
            sb.append("&begindate=" + begindate);
        }
        if(!StringUtils.isEmpty(enddate)){
            sb.append("&enddate=" + enddate);
        }
        List<Service>  list = restTemplate.getForObject(GetEurekaClient() + sb.toString(), List.class);
        return list;
    }




}
