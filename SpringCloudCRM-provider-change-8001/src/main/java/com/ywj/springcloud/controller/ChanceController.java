package com.ywj.springcloud.controller;

import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/change")
public class ChanceController {

    @Autowired
    private ChanceService chanceService;
    /**
     * 查询全部
     */
    @GetMapping("/findChenceMultiple")
    public  List<Map<String,Object>> fundChenceAll(String chc_cust_name, String chc_title, String chc_linkman, String chc_status){
        List<Map<String,Object>> chanceMultiple = chanceService.findChanceMultiple( chc_cust_name,  chc_title,  chc_linkman,  chc_status);
        return chanceMultiple;
    }

    /**
     * 添加
     */
    @RequestMapping("/addChance")
    public  int addChance(Chance chance){
            int i = chanceService.addChance(chance);
            return i;
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteChance/{chc_id}")
    public  int removeChan(@PathVariable("chc_id") Integer chc_id){
        int i = chanceService.deleteChance(chc_id);
        return i;
    }


    /**
     * 修改
     */
    @RequestMapping("/updateChance")
    public int editChance(Chance chance){
        int i = chanceService.updateChance(chance);
        return i;
    }

    /**
     * 指派
     */
    @RequestMapping("/assignChance")
    public  int assign(Chance chance){
        int i = chanceService.assign(chance);
        return i;
    }
}
