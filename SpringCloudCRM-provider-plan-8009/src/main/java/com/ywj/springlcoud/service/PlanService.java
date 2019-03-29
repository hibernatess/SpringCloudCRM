package com.ywj.springlcoud.service;


import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.entities.Plan;

import java.util.List;
import java.util.Map;

public interface PlanService {
    /**
     * 多条件查找制定开发计划
     */
    List<Map<String,Object>> findPlanMultiple(String chc_id);

    /**
     * 多条件查找制定开发计划
     */
    List<Map<String,Object>> fundChenCeAll(String chc_cust_name,String chc_title,String chc_linkman);

    /**
     *增加一个计划
     * @param plan
     * @return
     */
    int addPlan(Plan plan);

    /**
     *删除计划
     * @param pla_id
     * @return
     */
    int deletePlan(Integer pla_id);

    /**
     * 编辑计划
     * @param plan
     * @return
     */
    int updatePlan(Plan plan);

    /**
     * 修改结果
     * @return
     */
    int editPlanResult(Plan plan);

    /**
     * 修改状态
     * @return
     */
    int editChanStatus(Chance chance);

}
