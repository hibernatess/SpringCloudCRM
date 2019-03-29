package com.ywj.springlcoud.mapper;


import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.entities.Plan;
import com.ywj.springlcoud.sql.SqlPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PlanMapper {
    /**
     * 多条件查找制定开发计划
     */
    @SelectProvider(type = SqlPlan.class,method = "findPlanMultiple")
    List<Map<String,Object>> findPlanMultiple(String chc_id);

    /**
     * 多条件查找制定开发计划
     */
    @SelectProvider(type = SqlPlan.class,method = "fundChenCeAll")
    List<Map<String,Object>> fundChenCeAll(String chc_cust_name,String chc_title,String chc_linkman);

    /**
     *增加一个计划
     * @param plan
     * @return
     */
    @Insert("insert into sal_plan(pla_chc_id,pla_date,pla_todo) VALUES(#{pla_chc_id},#{pla_date},#{pla_todo}) ")
    int addPlan(Plan plan);

    /**
     *删除计划
     * @param pla_id
     * @return
     */
    @Delete("DELETE from sal_plan WHERE pla_id==#{pla_id}")
    int deletePlan(Integer pla_id);

    /**
     * 编辑计划
     * @param plan
     * @return
     */
    @Update("UPDATE sal_plan SET pla_todo=#{pla_todo} WHERE pla_id=#{pla_id}")
    int updatePlan(Plan plan);

    /**
     * 修改结果
     * @return
     */
    @Update("UPDATE sal_plan SET pla_result=#{pla_result} WHERE pla_id=#{pla_id}")
    int editPlanResult(Plan plan);

    /**
     * 修改状态
     * @return
     */
    @Update("UPDATE sal_chance SET chc_status=#{chc_status} WHERE chc_id=#{chc_id}")
    int editChanStatus(Chance chance);

}
