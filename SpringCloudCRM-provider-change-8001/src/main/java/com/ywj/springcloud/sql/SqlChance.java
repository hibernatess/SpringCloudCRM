package com.ywj.springcloud.sql;

import org.springframework.util.StringUtils;

public class SqlChance {
    /**
     * 同时根据多个查询条件来查询销售信息
     * @return
     * @throws Exception
     */
    public String findChanceMultiple(String chc_cust_name, String chc_title, String chc_linkman, String chc_status) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT c.*,u.usr_name,u.usr_password,u.usr_role_id,u.usr_flag FROM sal_chance c INNER JOIN sys_user u ON c.chc_create_id=u.usr_id WHERE TRUE ");
        if(!StringUtils.isEmpty(chc_title)){
            sb.append(" AND chc_title='"+chc_title+"' ");
        }
        if(!StringUtils.isEmpty(chc_linkman)){
            sb.append(" AND chc_linkman LIKE '%"+chc_linkman+"%' ");
        }
        if(!StringUtils.isEmpty(chc_status)){
            sb.append(" AND chc_status = '"+chc_status+"' ");
        }
        return sb.toString();
    }
}
