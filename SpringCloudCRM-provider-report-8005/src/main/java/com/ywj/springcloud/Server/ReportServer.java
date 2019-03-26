package com.ywj.springcloud.Server;

import com.ywj.springcloud.sql.SqlReport;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface ReportServer {

    /**
     * 查询客户贡献分析
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:13
     */
    List<Map<String,Object>> findContribution(String odr_cust_name, String odr_date);

    /**
     * 查询客户构成
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:20
     */
    List<Map<String, Object>> findConstitute(String type,String typename);

    /**
     * 查找客户服务分析
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:29
     */
    List<Map<String, Object>> findServe(String svr_create_date);


    /**
     * 查看流失顾客
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:32
     */
    List<Map<String,Object>> findlost(String lst_cust_name,String lst_cust_manager_name);

}
