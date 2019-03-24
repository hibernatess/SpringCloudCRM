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
    public String findServerMultiple(String svr_cust_name,String svr_title,String svr_type,String svr_status,String begindate,String enddate) throws ParseException {
        StringBuffer sb=new StringBuffer();
        //获取系统当前时间
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss");
        String date = df.format(d);
        //起始时间 如果没有传起始时间那么就从2017.01.01开始
        Date myDate2 = df.parse("2017年01月01日00时00分00秒");
        String date2 = df.format(myDate2);
        sb.append("SELECT * FROM cst_service WHERE TRUE ");
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
