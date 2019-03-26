package com.ywj.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ywj.springcloud.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    /**
     * 用与在eureka上找地址
     * @return
     */
    public String GetEurekaClient(){
        //去eureka上找SpringCloudCRM-8003
        InstanceInfo eureka = eurekaClient.getNextServerFromEureka("SpringCloudCRM-8005", false);
        //把找到后把取地址
        String homePageUrl = eureka.getHomePageUrl();
        return homePageUrl;
    }

    /**
     * 查询客户贡献分析
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:47
     */
    @RequestMapping("/findContribution")
    @ResponseBody
    public Map<String,Object> findContribution(String odr_cust_name, String odr_date, HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setPageBean(request);
        StringBuffer sb=new StringBuffer();
        sb.append("report/findContribution?true");
        if(!StringUtils.isEmpty(odr_cust_name)){
            sb.append("&odr_cust_name="+odr_cust_name);
        }
        if(!StringUtils.isEmpty(odr_date)){
            sb.append("&odr_date="+odr_date);
        }
        List<Map<String,Object>> list = restTemplate.getForObject(GetEurekaClient() + sb.toString(), List.class);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }

    /**
     * 查询客户构成
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:20
     */
    @RequestMapping("/findConstitute")
    @ResponseBody
    public Map<String,Object> findConstitute(String type,String typename,HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setPageBean(request);
        StringBuffer sb=new StringBuffer();
        sb.append("report/findConstitute?true");
        if(!StringUtils.isEmpty(type)){
            sb.append("&type="+type);
        }
        if(!StringUtils.isEmpty(typename)){
            sb.append("&ty.tospename="+typename);
        }
        List<Map<String,Object>> list = restTemplate.getForObject(GetEurekaClient() + sb.toString(), List.class);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }


    /**
     * 查找客户服务分析
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:54
     */
    @RequestMapping("/findServe")
    @ResponseBody
    public Map<String,Object> findServe(String svr_create_date,HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setPageBean(request);
        StringBuffer sb=new StringBuffer();
        sb.append("report/findServe?true");
        if(!StringUtils.isEmpty(svr_create_date)){
            sb.append("&svr_create_date="+svr_create_date);
        }
        List<Map<String,Object>> list = restTemplate.getForObject(GetEurekaClient() + sb.toString(), List.class);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }

    /**
     * 查看流失顾客
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:32
     */
    @RequestMapping("/findlost")
    @ResponseBody
    public Map<String,Object>  findlost(String lst_cust_name,String lst_cust_manager_name,HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setPageBean(request);
        StringBuffer sb=new StringBuffer();
        sb.append("report/findlost?true");
        if(!StringUtils.isEmpty(lst_cust_name)){
            sb.append("&lst_cust_name="+lst_cust_name);
        }
        if(!StringUtils.isEmpty(lst_cust_manager_name)){
            sb.append("&lst_cust_manager_name="+lst_cust_manager_name);
        }
        List<Map<String,Object>> list = restTemplate.getForObject(GetEurekaClient() + sb.toString(), List.class);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }
}
