package com.ywj.springlcoud.sql;

import org.springframework.util.StringUtils;

public class SqlPlan {

    /**
    * 同时根据多个查询条件来查询服务表  如果起始时间第一开始没有传值那么就使用默认时间
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/24 14:43
    */
    public String findPlanMultiple(String  chc_id) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT * FROM sal_plan p INNER JOIN sal_chance c on p.pla_chc_id=c.chc_id WHERE TRUE  ");
        if(!StringUtils.isEmpty(chc_id)){
            sb.append(" AND c.chc_id='"+chc_id+"' ");
        }
        return sb.toString();
    }

    public String fundChenCeAll(String chc_cust_name,String chc_title,String chc_linkman) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT c.*,u.usr_name,u.usr_password,u.usr_role_id,u.usr_flag FROM sal_chance c INNER JOIN sys_user u ON c.chc_create_id=u.usr_id WHERE TRUE and chc_status!='1'  ");
        if(!StringUtils.isEmpty(chc_cust_name)){
            sb.append(" and chc_cust_name like '%"+chc_cust_name+"%' ");
        }
        if(StringUtils.isEmpty(chc_title)){
            sb.append(" and chc_title like '%"+chc_title+"%' ");
        }
        if(StringUtils.isEmpty(chc_linkman)){
            sb.append(" and chc_linkman like '%"+chc_linkman+"%' ");
        }
        return sb.toString();
    }
}
