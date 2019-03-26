package com.ywj.springcloud.Server.impl;

import com.ywj.springcloud.Mapper.ReportMapper;
import com.ywj.springcloud.Server.ReportServer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ReportServerImpl implements ReportServer {

    @Autowired
    private ReportMapper reportMapper;

    /**
     * 查询客户贡献分析
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:13
     */
    @Override
    public List<Map<String, Object>> findContribution(String odr_cust_name, String odr_date) {
        return reportMapper.findContribution(odr_cust_name, odr_date);
    }

    /**
     * 查询客户构成
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:20
     */
    @Override
    public List<Map<String, Object>> findConstitute(String type, String typename) {
        return reportMapper.findConstitute(type, typename);
    }

    /**
     * 查找客户服务分析
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:29
     */
    @Override
    public List<Map<String, Object>> findServe(String svr_create_date) {
        return reportMapper.findServe(svr_create_date);
    }

    /**
     * 查看流失顾客
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/26 11:32
     */
    @Override
    public List<Map<String, Object>> findlost(String lst_cust_name, String lst_cust_manager_name) {
        return reportMapper.findlost(lst_cust_name, lst_cust_manager_name);
    }
}
