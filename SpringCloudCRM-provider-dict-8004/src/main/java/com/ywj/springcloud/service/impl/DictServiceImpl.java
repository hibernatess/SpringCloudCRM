package com.ywj.springcloud.service.impl;

import com.ywj.springcloud.entities.Dict;
import com.ywj.springcloud.mapper.DictMapper;
import com.ywj.springcloud.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DictServiceImpl
 * @Author ywj
 * @Describe
 * @Date 2019/3/26 0026 16:16
 */
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;



    @Override
    public List<Dict> loadDict(Dict dict) {
        return dictMapper.loadDict(dict);
    }
}
