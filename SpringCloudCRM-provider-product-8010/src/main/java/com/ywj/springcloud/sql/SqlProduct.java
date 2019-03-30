package com.ywj.springcloud.sql;

import org.springframework.util.StringUtils;

public class SqlProduct {
    /**
     * 同时根据多个查询条件来查询产品信息
     * @return
     * @throws Exception
     */
    public String listProduct(String prod_name, String prod_type, String prod_batch) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT * FROM product WHERE TRUE ");
        if(!StringUtils.isEmpty(prod_type)){
            sb.append(" AND prod_type LIKE '%"+prod_type+"%' ");
        }
        if(!StringUtils.isEmpty(prod_batch)){
            sb.append(" AND prod_batch LIKE '%"+prod_batch+"%' ");
        }
        if(!StringUtils.isEmpty(prod_name)){
            sb.append(" AND prod_name LIKE '%"+prod_name+"%' ");
        }
        return sb.toString();
    }

    /**
     * 同时根据多个查询条件来查询库存信息
     * @return
     * @throws Exception
     */
    public String listStorage(String prod_name, String stk_warehouse) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT * FROM product p INNER JOIN `storage` s ON p.prod_id=s.stk_prod_id WHERE TRUE ");
        if(!StringUtils.isEmpty(prod_name)){
            sb.append(" AND p.prod_name LIKE '%"+prod_name+"%' ");
        }
        if(!StringUtils.isEmpty(stk_warehouse)){
            sb.append(" AND s.stk_warehouse LIKE '%"+stk_warehouse+"%' ");
        }
        return sb.toString();
    }
}
