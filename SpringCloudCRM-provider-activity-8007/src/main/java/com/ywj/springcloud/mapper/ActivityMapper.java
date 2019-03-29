package com.ywj.springcloud.mapper;


import com.ywj.springcloud.entities.Activity;
import com.ywj.springcloud.sql.SqlActivity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ActivityMapper {
    /**
     * 多条件查看交往记录
     */
    @SelectProvider(type = SqlActivity.class,method = "findActivityMultiple")
    List<Map<String,Object>> findActivityMultiple(String atv_cust_no);

    /**
     *增加交往记录
     * @param Activity
     * @return
     */
    @Insert("INSERT INTO cst_activity(atv_cust_no,atv_cust_name,atv_date,atv_place,atv_title,atv_remark,atv_desc) VALUES(#{atv_cust_no},#{atv_cust_name},#{atv_date},#{atv_place},#{atv_title},#{atv_remark},#{atv_desc})")
    int addActivity(Activity Activity);

    /**
     *删除交往记录
     * @param chc_id
     * @return
     */
    @Delete("DELETE FROM cst_activity WHERE atv_id=#{atv_id}")
    int deleteActivity(Integer chc_id);

    /**
     * 编辑交往记录
     * @param activity
     * @return
     */
    @Update("UPDATE cst_activity SET atv_place=#{atv_place},atv_title=#{atv_title},atv_remark=#{atv_remark},atv_desc=#{atv_desc} WHERE atv_id=#{atv_id}")
    int updateActivity(Activity activity);

}
