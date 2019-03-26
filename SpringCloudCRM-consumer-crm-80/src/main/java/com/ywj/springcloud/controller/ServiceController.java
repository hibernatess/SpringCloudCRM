package com.ywj.springcloud.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ywj.springcloud.entities.Service;
import com.ywj.springcloud.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    SpringCloudCRM-provider-server-8003的消费端
* @Author:         hhh
* @CreateDate:
* @UpdateUser:     hhh
* @UpdateDate:
*/
@Controller
public class ServiceController {

    @Autowired
    private RestTemplate restTemplate;



    /**
     * 添加服务（创建服务）
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:31
     */
    @RequestMapping("/addService")
    @ResponseBody
    public int addService(Service service){
        //访问服务层，获取数据
        Integer object = restTemplate.getForObject("http://SPRINGCLOUDCRM-8003/server/addService?" + service, Integer.class);
        return object;
    }

    /**
     * 多条件查询
     * SelectProvider type找到对应的类  method使用次类里面的方法做sql语句 进行数据库的操作
     * @author      hhh
     * @return      返回server的集合
     * @exception
     * @date        2019/3/24 14:45
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findServerMultiple(String svr_cust_name, String svr_title, String svr_type, String svr_status, String begindate, String enddate, HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setPageBean(request);
        StringBuffer sb=new StringBuffer();
        sb.append("http://SPRINGCLOUDCRM-8003/server/findServerMultiple?true");
        if(!StringUtils.isEmpty(svr_cust_name)){
            sb.append("&svr_cust_name=" + svr_cust_name);
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
        List<Service>  list = restTemplate.getForObject( sb.toString(), List.class);
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
     * 删除单个服务
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:30
     */
    @RequestMapping("/deleteService/{svr_id}")
    @ResponseBody
    public int deleteService(@PathVariable("svr_id") Integer svr_id){
        Integer i = restTemplate.getForObject("http://SPRINGCLOUDCRM-8003/server/deleteService/" + svr_id, Integer.class);
        return i;
    }

    /**
     * 处理新创建的服务  改成已分配 分配给那个员工(id,name)修改分配时间
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:54
     */
    @RequestMapping("/updateAllocation")
    @ResponseBody
    public int updateAllocation(Service service){
        Integer i = restTemplate.getForObject( "http://SPRINGCLOUDCRM-8003/server/updateAllocation?" + service, Integer.class);
        return i;
    }

    /**
     * 在分配之后最处理  对分配下去的服务进行处理 根据id修改处理的结果 修改处理人  和处理时间
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 14:06
     */
    @RequestMapping("/updateDispose")
    @ResponseBody
    public int updateDispose(Service service){
        Integer i = restTemplate.getForObject("http://SPRINGCLOUDCRM-8003/server/updateDispose?"+service, Integer.class);
        return i;
    }

    /**
     * 对处理之后客户的反馈  看看是否满意  如果满意就归档  不满意返回至服务处理从新进行处理
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 14:13
     */
    @RequestMapping("/updateResult")
    @ResponseBody
    public int updateResult(Service service){
        Integer i = restTemplate.getForObject("http://SPRINGCLOUDCRM-8003//server/updateResult" + service, Integer.class);
        return i;
    }

    /**
    * 跳转至添加服务页面
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/26 9:50
    */
    @GetMapping("/add")
    public String get(){
        return "addServe";
    }

}
