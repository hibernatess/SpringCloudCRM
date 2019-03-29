package com.ywj.springcloud.service.impl;

import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.mapper.ChanceMapper;
import com.ywj.springcloud.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChanceServiceImpl implements ChanceService {

    @Autowired
    private ChanceMapper chanceMapper;

    @Override
    public List<Map<String, Object>> findChanceMultiple(String chc_cust_name, String chc_title, String chc_linkman, String chc_status) {
        return chanceMapper.findChanceMultiple(chc_cust_name,chc_title,chc_linkman,chc_status);
    }

    @Override
    public int addChance(Chance chance) {
        return chanceMapper.addChance(chance);
    }

    @Override
    public int deleteChance(Integer chc_id) {
        return chanceMapper.deleteChance(chc_id);
    }

    @Override
    public int updateChance(Chance chance) {
        return chanceMapper.updateChance(chance);
    }

    @Override
    public int assign(Chance chance) {
        return chanceMapper.assign(chance);
    }
}
