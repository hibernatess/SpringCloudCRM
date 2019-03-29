package com.ywj.springlcoud.controller;


import com.ywj.springcloud.entities.Linkman;
import com.ywj.springlcoud.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/linkman")
public class LinkmanController {

    @Autowired
    private LinkmanService linkmanService;
    /**
     * 查询全部
     */
    @GetMapping("/findChenceMultiple")
    public List<Map<String,Object>> fundLinkmanAll(String lkm_id){
        List<Map<String,Object>> LinkmanMultiple = linkmanService.findLinkmanMultiple(lkm_id);
        return LinkmanMultiple;
    }

    /**
     * 添加
     */
    @RequestMapping("/addActivity")
    public  int addLinkman(Linkman activity){
        int i = linkmanService.addLinkman(activity);
        return i;
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteLinkman/{lkm_id}")
    public  int removeChan(@PathVariable("lkm_id") Integer lkm_id){
        int i = linkmanService.deleteLinkman(lkm_id);
        return i;
    }


    /**
     * 修改
     */
    @RequestMapping("/updateLinkman")
    public int editLinkman(Linkman linkman){
        int i = linkmanService.updateLinkman(linkman);
        return i;
    }

}
