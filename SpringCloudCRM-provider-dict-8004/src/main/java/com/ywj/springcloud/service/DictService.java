package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.Dict;

import java.util.List;

public interface DictService {

    /**
     *@Description:   用于基础数据的类别查询
     * @Param: [dict]
     * @return: java.util.List<com.ywj.springcloud.entities.Dict>
     * @Author: ywj
     * @Date: 2019/3/26 0026
     */
    List<Dict> loadDict(Dict dict);


}
