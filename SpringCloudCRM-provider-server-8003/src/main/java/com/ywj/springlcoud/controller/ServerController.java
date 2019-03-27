package com.ywj.springlcoud.controller;

import com.ywj.springcloud.entities.Service;
import com.ywj.springlcoud.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ServerService serverService;


    /**
    * 添加服务（创建服务)
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/24 15:22
    */
    @RequestMapping("/addService")
    public int addService(Service service){
        int i = serverService.addService(service);
        return i;
    }

    /**
     * 多条件查询
     * SelectProvider type找到对应的类  method使用次类里面的方法做sql语句 进行数据库的操作
     * @author      hhh
     * @return      返回server的集合
     * @exception
     * @date        2019/3/24 14:45
     */
    @GetMapping("/findServerMultiple")
    public List<Map<String,Object>> findServerMultiple(String svr_cust_name,String svr_title,String svr_type,String svr_status,String begindate,String enddate){
        List<Map<String,Object>> serverMultiple = serverService.findServerMultiple(svr_cust_name, svr_title, svr_type, svr_status, begindate, enddate);
        return serverMultiple;
    }

    /**
     * 删除单个服务
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:30
     */
    @RequestMapping("/deleteService/{svr_id}")
    public int deleteService(@PathVariable("svr_id") Integer svr_id){
        int i = serverService.deleteService(svr_id);
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
    public int updateAllocation(Service service){
        int i = serverService.updateAllocation(service);
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
    public int updateDispose(Service service){
        int i = serverService.updateDispose(service);
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
    public int updateResult(Service service){
        int i = serverService.updateResult(service);
        return i;
    }

}
