package com.ywj.springlcoud.sql;

import org.springframework.util.StringUtils;

public class SqlLinkman {

    /**
    * 同时根据多个查询条件来查询服务表  如果起始时间第一开始没有传值那么就使用默认时间
    */
    public String findLinkmanMultiple(String  lkm_cust_no) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT * FROM cst_linkman WHERE true ");
        if(!StringUtils.isEmpty(lkm_cust_no)){
            sb.append(" AND lkm_cust_no='"+lkm_cust_no+"' ");
        }
        return sb.toString();
    }
}
