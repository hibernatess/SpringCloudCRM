package com.ywj.springcloud.controller;

import com.ywj.springcloud.Server.ReportServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportServer reportServer;

    /**
    * 查询客户贡献分析
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/26 11:47
    */
    @GetMapping("/findContribution")
    public List<Map<String,Object>> findContribution(String odr_cust_name, String odr_date){
        List<Map<String, Object>> list = reportServer.findContribution(odr_cust_name, odr_date);
        return list;
    }

    /**
     * 查询客户构成
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:20
     */
    @GetMapping("/findConstitute")
    public List<Map<String,Object>> findConstitute(String type,String typename){
        List<Map<String, Object>> list = reportServer.findConstitute(type, typename);
        return list;
    }

    /**
    * 查找客户服务分析
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/26 11:54
    */
    @GetMapping("/findServe")
    public List<Map<String,Object>> findServe(String svr_create_date){
        List<Map<String, Object>> list = reportServer.findServe(svr_create_date);
        return list;
    }

    /**
     * 查看流失顾客
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:32
     */
    @GetMapping("/findlost")
    public List<Map<String,Object>> findlost(String lst_cust_name,String lst_cust_manager_name){
        List<Map<String, Object>> list = reportServer.findlost(lst_cust_name, lst_cust_manager_name);
        return list;
    }

}
