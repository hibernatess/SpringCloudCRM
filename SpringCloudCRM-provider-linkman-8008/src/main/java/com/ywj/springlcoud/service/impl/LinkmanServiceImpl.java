package com.ywj.springlcoud.service.impl;


import com.ywj.springcloud.entities.Linkman;
import com.ywj.springlcoud.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywj.springlcoud.mapper.LinkmanMapper;

import java.util.List;
import java.util.Map;

@Service
public class LinkmanServiceImpl implements LinkmanService {
    @Autowired
    private LinkmanMapper linkmanMapper;
    @Override
    public List<Map<String, Object>> findLinkmanMultiple(String lkm_cust_no) {
        return linkmanMapper.findLinkmanMultiple(lkm_cust_no);
    }

    @Override
    public int addLinkman(Linkman linkman) {
        return linkmanMapper.addLinkman(linkman);
    }

    @Override
    public int deleteLinkman(Integer lkm_id) {
        return linkmanMapper.deleteLinkman(lkm_id);
    }

    @Override
    public int updateLinkman(Linkman linkman) {
        return linkmanMapper.updateLinkman(linkman);
    }
}
