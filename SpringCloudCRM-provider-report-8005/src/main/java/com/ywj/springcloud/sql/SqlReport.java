package com.ywj.springcloud.sql;

import org.springframework.util.StringUtils;

public class SqlReport {

    /**
    * 查询客户贡献分析的sql语句
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/26 11:16
    */
    public String findContribution(String odr_cust_name,String odr_date){
            StringBuffer sb=new StringBuffer();
            sb.append("SELECT o.odr_id,o.odr_cust_name,o.odr_date,SUM(l.odd_price*l.odd_count) as price FROM orders o LEFT JOIN orders_line l ON o.odr_id=l.odd_order_id WHERE TRUE");
            if(!StringUtils.isEmpty(odr_cust_name)){
                sb.append("AND o.odr_cust_name LIKE '%"+odr_cust_name+"%' ");
            }
            if(!StringUtils.isEmpty(odr_date)){
                sb.append("AND o.odr_date LIKE '%"+odr_date+"%' ");
            }
            return sb.toString();
    }

    /**
    * 查询客户构成的sql语句
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/26 11:21
    */
    public String findConstitute(String type,String typename){
        StringBuffer sb=new StringBuffer();
        if(StringUtils.isEmpty(type)){
            type="cust_satisfy";
        }
        if(StringUtils.isEmpty(typename)){
            typename="客户等级";
        }
        sb.append("SELECT d.dict_item,d.dict_value,COUNT(c.cust_no) as sum FROM cst_customer c RIGHT JOIN bas_dict d ON c."+type+"=d.dict_item WHERE TRUE");
        sb.append(" AND d.dict_type='"+typename+"' ");
        sb.append("GROUP BY d.dict_value");
        return sb.toString();
    }


    /**
    * 查找客户服务分析的sql语句
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/26 11:31
    */
    public String findServe(String svr_create_date){
       StringBuffer sb=new StringBuffer();
       sb.append("SELECT d.dict_item,d.dict_value,COUNT(svr_id) as sum FROM cst_service s RIGHT JOIN bas_dict d ON s.svr_type=d.dict_item WHERE d.dict_type='服务类型' ");
       if(!StringUtils.isEmpty(svr_create_date)){
           sb.append(" AND s.svr_create_date LIKE '"+svr_create_date+"%' ");
       }
       return sb.toString();
    }

    /**
    * 查看流失顾客的sql语句
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/26 11:32
    */
    public String findlost(String lst_cust_name,String lst_cust_manager_name){
        StringBuffer sb=new StringBuffer();
        sb.append("select lst_id,LEFT(lst_lost_date,4) as lst_lost_date,lst_cust_name,lst_cust_manager_name,lst_reason FROM cst_lost WHERE TRUE ");
        if(!StringUtils.isEmpty(lst_cust_name)){
            sb.append(" AND lst_cust_name LIKE '%"+lst_cust_name+"%' ");
        }
        if(!StringUtils.isEmpty(lst_cust_manager_name)){
            sb.append(" AND lst_cust_manager_name LIKE '%"+lst_cust_manager_name+"%'");
        }
        return sb.toString();
    }

}
