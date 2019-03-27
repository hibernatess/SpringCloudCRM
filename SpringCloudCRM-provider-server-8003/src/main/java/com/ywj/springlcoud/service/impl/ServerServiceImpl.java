package com.ywj.springlcoud.service.impl;

import com.ywj.springcloud.entities.Service;
import com.ywj.springlcoud.mapper.ServiceMapper;
import com.ywj.springlcoud.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServiceMapper serviceMapper;

    /**
     * 添加服务（创建服务）
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:31
     */
    @Override
    public int addService(Service service) {
        return serviceMapper.addService(service);
    }

    /**
     * 多条件查询
     * SelectProvider type找到对应的类  method使用次类里面的方法做sql语句 进行数据库的操作
     * @author      hhh
     * @return      返回server的集合
     * @exception
     * @date        2019/3/24 14:45
     */
    @Override
    public List<Map<String,Object>> findServerMultiple(String svr_cust_name, String svr_title, String svr_type, String svr_status, String begindate, String enddate) {
        return serviceMapper.findServerMultiple(svr_cust_name, svr_title, svr_type, svr_status, begindate, enddate);
    }

    /**
     * 删除单个服务
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:30
     */
    @Override
    public int deleteService(Integer svr_id) {
        return serviceMapper.deleteService(svr_id);
    }

    /**
     * 处理新创建的服务  改成已分配 分配给那个员工(id,name)修改分配时间
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 11:54
     */
    @Override
    public int updateAllocation(Service service) {
        return serviceMapper.updateAllocation(service);
    }

    /**
     * 在分配之后最处理  对分配下去的服务进行处理 根据id修改处理的结果 修改处理人  和处理时间
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 14:06
     */
    @Override
    public int updateDispose(Service service) {
        return serviceMapper.updateDispose(service);
    }

    /**
     * 对处理之后客户的反馈  看看是否满意  如果满意就归档  不满意返回至服务处理从新进行处理
     * @author      hhh
     * @return
     * @exception
     * @date        2019/3/24 14:13
     */
    @Override
    public int updateResult(Service service) {
        return serviceMapper.updateResult(service);
    }
}
