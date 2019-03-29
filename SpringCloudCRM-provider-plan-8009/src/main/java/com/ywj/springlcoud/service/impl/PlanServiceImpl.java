package com.ywj.springlcoud.service.impl;


import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.entities.Plan;
import com.ywj.springlcoud.mapper.PlanMapper;
import com.ywj.springlcoud.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;

    @Override
    public List<Map<String, Object>> findPlanMultiple(String chc_id) {
        return planMapper.findPlanMultiple(chc_id);
    }

    @Override
    public List<Map<String, Object>> fundChenCeAll(String chc_cust_name, String chc_title, String chc_linkman) {
        return planMapper.fundChenCeAll(chc_cust_name,chc_title,chc_linkman);
    }

    @Override
    public int addPlan(Plan plan) {
        return planMapper.addPlan(plan);
    }

    @Override
    public int deletePlan(Integer pla_id) {
        return planMapper.deletePlan(pla_id);
    }

    @Override
    public int updatePlan(Plan plan) {
        return planMapper.updatePlan(plan);
    }

    @Override
    public int editPlanResult(Plan plan) {
        return planMapper.editPlanResult(plan);
    }

    @Override
    public int editChanStatus(Chance chance) {
        return planMapper.editChanStatus(chance);
    }
}
