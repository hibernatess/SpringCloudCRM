package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.Chance;

import java.util.List;
import java.util.Map;

public interface ChanceService {
    /**
     * 多条件查询销售信息
     */
    List<Map<String,Object>> findChanceMultiple(String chc_cust_name, String chc_title, String chc_linkman, String chc_status);

    /**
     *增加销售信息
     * @param chance
     * @return
     */
    int addChance(Chance chance);

    /**
     *删除销售信息
     * @param chc_id
     * @return
     */
    int deleteChance(Integer chc_id);

    /**
     * 修改销售信息
     * @param chance
     * @return
     */
    int updateChance(Chance chance);

    /**
     * 指派
     * @param chance
     * @return
     */
    int assign(Chance chance);
}