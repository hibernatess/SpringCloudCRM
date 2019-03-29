package com.ywj.springcloud.controller;

import com.ywj.springcloud.entities.Activity;
import com.ywj.springcloud.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActiviyController {

    @Autowired
    private ActivityService activityService;
    /**
     * 查询全部
     */
    @GetMapping("/findChenceMultiple")
    public  List<Map<String,Object>> fundChenceAll(String atv_cust_no){
        List<Map<String,Object>> ActiviyMultiple = activityService.findActiviyMultiple(atv_cust_no);
        return ActiviyMultiple;
    }

    /**
     * 添加
     */
    @RequestMapping("/addActivity")
    public  int addActiviy(Activity activity){
            int i = activityService.addActiviy(activity);
            return i;
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteActivity/{atv_id}")
    public  int removeChan(@PathVariable("atv_id") Integer atv_id){
        int i = activityService.deleteActivity(atv_id);
        return i;
    }


    /**
     * 修改
     */
    @RequestMapping("/updateActivity")
    public int editActiviy(Activity activity){
        int i = activityService.updateActivity(activity);
        return i;
    }

}
