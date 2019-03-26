package com.ywj.springcloud.controller;

import com.ywj.springcloud.entities.Dict;
import com.ywj.springcloud.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DictCtroller
 * @Author ywj
 * @Describe
 * @Date 2019/3/26 0026 16:18
 */
@RestController
public class DictCtroller {
    @Autowired
    private DictService dictService;
    /**    
        *@Description: 根据类型获取基础数据
        * @Param: [dict]
        * @return: java.util.List<com.ywj.springcloud.entities.Dict>
        * @Author: ywj
        * @Date: 2019/3/26 0026
        */
    @GetMapping("/loaddict")
    public List<Dict> loadDict(Dict dict){
      return   dictService.loadDict(dict);
    }

}
