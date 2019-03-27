package com.ywj.springcloud.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ywj.springcloud.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
        sb.append("http://SPRINGCLOUDCRM-8005/report/findContribution?true");
        if(!StringUtils.isEmpty(odr_cust_name)){
            sb.append("&odr_cust_name="+odr_cust_name);
        }
        if(!StringUtils.isEmpty(odr_date)){
            sb.append("&odr_date="+odr_date);
        }
        List<Map<String,Object>> list = restTemplate.getForObject(sb.toString(), List.class);
        Page page=PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        PageInfo pageInfo=new PageInfo(list);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
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
        sb.append("http://SPRINGCLOUDCRM-8005/report/findConstitute?true");
        if(!StringUtils.isEmpty(type)){
            sb.append("&type="+type);
        }
        if(!StringUtils.isEmpty(typename)){
            sb.append("&typename="+typename);
        }
        List<Map<String,Object>> list = restTemplate.getForObject( sb.toString(), List.class);
        Page page=PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        PageInfo pageInfo=new PageInfo(list);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
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
        sb.append("http://SPRINGCLOUDCRM-8005/report/findServe?true");
        if(!StringUtils.isEmpty(svr_create_date)){
            sb.append("&svr_create_date="+svr_create_date);
        }
        List<Map<String,Object>> list = restTemplate.getForObject( sb.toString(), List.class);
        Page page=PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        PageInfo pageInfo=new PageInfo(list);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
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
        sb.append("http://SPRINGCLOUDCRM-8005/report/findlost?true");
        if(!StringUtils.isEmpty(lst_cust_name)){
            sb.append("&lst_cust_name="+lst_cust_name);
        }
        if(!StringUtils.isEmpty(lst_cust_manager_name)){
            sb.append("&lst_cust_manager_name="+lst_cust_manager_name);
        }
        List<Map<String,Object>> list = restTemplate.getForObject( sb.toString(), List.class);
        Page page=PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        PageInfo pageInfo=new PageInfo(list);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    /**
    * 跳转至客户贡献统计页面
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/27 9:34
    */
    @RequestMapping("/contribution")
    public String getcontribution(){
        return "contribution";
    }

    /**
    * 跳转至客户构成统计页面
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/27 9:35
    */
    @RequestMapping("/constitute")
    public String getconstitute(){
        return  "constitute";
    }

    /**
    * 跳转至客户服务统计页面
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/27 9:42
    */
    @RequestMapping("/serve")
    public String getserve(){
        return  "serve";
    }

    /**
    * 跳转至客户流失统计页面
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/27 10:05
    */
    @RequestMapping("/findLost")
    public String getfindLost(){
        return "findLost";
    }

}
