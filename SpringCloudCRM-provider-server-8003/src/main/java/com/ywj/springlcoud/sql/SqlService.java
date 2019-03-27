package com.ywj.springlcoud.sql;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlService {

    /**
    * 同时根据多个查询条件来查询服务表  如果起始时间第一开始没有传值那么就使用默认时间
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/24 14:43
    */
    public String findServerMultiple(String svr_cust_name,String svr_title,String svr_type,String svr_status,String begindate,String enddate) throws Exception {
        StringBuffer sb=new StringBuffer();
        //获取系统当前时间
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss");
        String date = df.format(d);
        //起始时间 如果没有传起始时间那么就从2017.01.01开始
        Date myDate2 = df.parse("2017年01月01日00时00分00秒");
        String date2 = df.format(myDate2);
        sb.append("SELECT s.svr_id,d.dict_value,s.svr_title,s.svr_cust_no,svr_cust_name,s.svr_status,s.svr_request,s.svr_create_id,s.svr_create_by,s.svr_create_date,s.svr_due_id,s.svr_due_to,s.svr_due_date,s.svr_deal,s.svr_deal_id,s.svr_deal_by,s.svr_deal_date,s.svr_result,s.svr_satisfy ");
        sb.append("FROM cst_service s LEFT  JOIN bas_dict d ON s.svr_type=d.dict_item WHERE TRUE AND d.dict_type='服务类型'");
        if(!StringUtils.isEmpty(svr_status)){
            sb.append(" AND svr_status='"+svr_status+"' ");
        }
        if(!StringUtils.isEmpty(svr_cust_name)){
            sb.append(" AND svr_cust_name LIKE '%"+svr_cust_name+"%' ");
        }
        if(!StringUtils.isEmpty(svr_title)){
            sb.append(" AND svr_title LIKE '%"+svr_title+"%' ");
        }
        if(!StringUtils.isEmpty(svr_type)){
            sb.append(" AND svr_type='"+svr_type+"' ");
        }
        if(!StringUtils.isEmpty(begindate)&&!StringUtils.isEmpty(enddate)){
            sb.append("and svr_create_date between '" + begindate + "' and '" + enddate + "' ");
        }else if(!StringUtils.isEmpty(begindate)&&StringUtils.isEmpty(enddate)){
            sb.append(" and svr_create_date between '" + begindate + "' and '" + date + "' ");
        }else if(StringUtils.isEmpty(begindate)&&!StringUtils.isEmpty(enddate)){
            sb.append("and svr_create_date between '" + date2 + "' and '" + enddate + "' ");
        }
        return sb.toString();
    }
}
