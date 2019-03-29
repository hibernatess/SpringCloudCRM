package com.ywj.springcloud.sql;

import org.springframework.util.StringUtils;

public class SqlActivity {
    /**
     * 同时根据多个查询条件来查询销售信息
     * @return
     * @throws Exception
     */
    public String  findActivityMultiple(String atv_cust_no){
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT * FROM `cst_activity` WHERE TRUE ");
        if(!StringUtils.isEmpty(atv_cust_no)){
            sb.append(" AND atv_cust_no='"+atv_cust_no+"' ");
        }
        return sb.toString();
    }
}
