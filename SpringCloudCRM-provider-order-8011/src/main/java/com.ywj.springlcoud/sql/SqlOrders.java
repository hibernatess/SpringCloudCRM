package com.ywj.springlcoud.sql;

import org.springframework.util.StringUtils;

public class SqlOrders{

    /**
    *历史订单
    */
    public String listOrder(String  odr_cust_id) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT * FROM orders WHERE TRUE ");
        if(!StringUtils.isEmpty(odr_cust_id)){
            sb.append(" AND odr_cust_id='"+odr_cust_id+"' ");
        }
        return sb.toString();
    }
    /**
     *历史订单详情
     */
    public String findOrder(String odd_order_id ) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append(" SELECT * FROM orders_line l INNER JOIN product p ON l.odd_prod_id=p.prod_id WHERE TRUE   ");
        if(!StringUtils.isEmpty(odd_order_id)){
            sb.append(" AND l.odd_order_id='"+odd_order_id+"' ");
        }
        return sb.toString();
    }
    /**
     * 总价格
     */
    public String findSum(String odd_order_id ) throws Exception {
        StringBuffer sb=new StringBuffer();
        sb.append(" SELECT SUM(odd_price*odd_count) as sum FROM orders_line l INNER JOIN product p ON l.odd_prod_id=p.prod_id WHERE TRUE  ");
        if(!StringUtils.isEmpty(odd_order_id)){
            sb.append(" AND l.odd_order_id='"+odd_order_id+"' ");
        }
        return sb.toString();
    }
}
