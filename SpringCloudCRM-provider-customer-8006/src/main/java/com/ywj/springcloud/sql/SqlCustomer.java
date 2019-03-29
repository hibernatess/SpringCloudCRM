package com.ywj.springcloud.sql;

import org.springframework.util.StringUtils;

public class SqlCustomer {
    /**
     * 同时根据多个查询条件来查询客户信息
     * @return
     * @throws Exception
     */
    public String findChanceMultiple(String cust_status, String cust_name) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append(" SELECT * FROM cst_customer where true ");
        if(!StringUtils.isEmpty(cust_status)){
            sb.append(" AND cust_status='"+cust_status+"' ");
        }
        if(!StringUtils.isEmpty(cust_name)){
            sb.append(" AND cust_name LIKE '%"+cust_name+"%' ");
        }
        return sb.toString();
    }
}
