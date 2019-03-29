package com.ywj.springlcoud.mapper;


import com.ywj.springcloud.entities.Linkman;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.ywj.springlcoud.sql.SqlLinkman;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LinkmanMapper {
    /**
     * 多条件查看联系人
     */
    @SelectProvider(type = SqlLinkman.class,method = "findLinkmanMultiple")
    List<Map<String,Object>> findLinkmanMultiple(String lkm_cust_no);

    /**
     *增加联系人
     * @param linkman
     * @return
     */
    @Insert("INSERT INTO cst_linkman(lkm_cust_no,lkm_cust_name,lkm_name,lkm_sex,lkm_postion,lkm_tel,lkm_mobile,lkm_memo)VALUES(#{lkm_cust_no},#{lkm_cust_name},#{lkm_name},#{lkm_sex},#{lkm_postion},#{lkm_tel},#{lkm_mobile},#{lkm_memo}) ")
    int addLinkman(Linkman linkman);

    /**
     *删除联系人
     * @param lkm_id
     * @return
     */
    @Delete("DELETE from cst_linkman WHERE lkm_id==#{lkm_id}")
    int deleteLinkman(Integer lkm_id);

    /**
     * 编辑联系人
     * @param linkman
     * @return
     */
    @Update("UPDATE cst_linkman SET lkm_name=#{lkm_name},lkm_sex=#{lkm_sex},lkm_postion=#{lkm_postion},lkm_tel=#{lkm_tel},lkm_mobile=#{lkm_mobile},lkm_memo=#{lkm_memo} WHERE lkm_id=#{lkm_id}")
    int updateLinkman(Linkman linkman);
}
