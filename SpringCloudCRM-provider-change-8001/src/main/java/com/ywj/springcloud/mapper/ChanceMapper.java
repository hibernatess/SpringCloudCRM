package com.ywj.springcloud.mapper;

import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.sql.SqlChance;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ChanceMapper {
    /**
     * 多条件查询销售信息
     */
    @SelectProvider(type = SqlChance.class,method = "findChanceMultiple")
    List<Map<String,Object>> findChanceMultiple(String chc_cust_name, String chc_title, String chc_linkman, String chc_status);

    /**
     *增加销售信息
     * @param chance
     * @return
     */
    @Insert("INSERT INTO sal_chance(chc_source,chc_cust_name,chc_title,chc_rate,chc_linkman,chc_tel,chc_desc,chc_create_id,chc_create_by,chc_create_date,chc_status) " +
            "VALUES(#{chc_source},#{chc_cust_name},#{chc_title},#{chc_rate},#{chc_linkman},#{chc_tel},#{chc_desc},#{chc_create_id},#{chc_create_by},#{chc_create_date},#{chc_status})")
    int addChance(Chance chance);

    /**
     *删除销售信息
     * @param chc_id
     * @return
     */
    @Delete("DELETE FROM sal_chance  WHERE chc_id=#{chc_id}")
    int deleteChance(Integer chc_id);

    /**
     * 修改客户信息
     * @param chance
     * @return
     */
    @Update("UPDATE sal_chance SET chc_source=#{chc_source},chc_cust_name=#{chc_cust_name},chc_title=#{chc_title},chc_rate=#{chc_rate},chc_linkman=#{chc_linkman},chc_tel=#{chc_tel},chc_desc=#{chc_desc}  WHERE chc_id=#{chc_id}")
    int updateChance(Chance chance);

    /**
     * 指派
     * @param chance
     * @return
     */
    @Update("UPDATE sal_chance SET chc_due_id=#{chc_due_id},chc_due_to=#{chc_due_to},chc_due_date=#{chc_due_date},chc_status=2 where chc_id=#{chc_id}")
    int assign(Chance chance);

}
