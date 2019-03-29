package com.ywj.springlcoud.controller;


import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.entities.Plan;
import com.ywj.springlcoud.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;
    /**
     * 查找制定开发计划
     */
    @GetMapping("/findChenceMultiple")
    public List<Map<String,Object>> fundPlanAll(String chc_id){
        List<Map<String,Object>> PlanMultiple = planService.findPlanMultiple(chc_id);
        return PlanMultiple;
    }

    /**
     * 查询全部
     */
    @GetMapping("/fundChenCeAll")
    public List<Map<String,Object>> fundChenCeAll(String chc_cust_name,String chc_title,String chc_linkman){
        List<Map<String,Object>> PlanMultiple = planService.fundChenCeAll( chc_cust_name, chc_title, chc_linkman);
        return PlanMultiple;
    }

    /**
     * 添加一个计划
     */
    @RequestMapping("/addPlan")
    public  int addPlan(Plan plan){
        int i = planService.addPlan(plan);
        return i;
    }

    /**
     * 删除计划
     */
    @RequestMapping("/deletePlan/{pla_id}")
    public  int removePlan(@PathVariable("pla_id") Integer pla_id){
        int i = planService.deletePlan(pla_id);
        return i;
    }


    /**
     * 修改计划
     */
    @RequestMapping("/updatePlan")
    public int editPlan(Plan plan){
        int i = planService.updatePlan(plan);
        return i;
    }
    /**
     *修改结果
     */
    @RequestMapping("/editPlanResult")
    public int editPlanResult(Plan plan){
        int i = planService.editPlanResult(plan);
        return i;
    }
    /**
     * 修改状态
     */
    @RequestMapping("/editChanStatus")
    public int editChanStatus(Chance chance){
        int i = planService.editChanStatus(chance);
        return i;
    }

}
