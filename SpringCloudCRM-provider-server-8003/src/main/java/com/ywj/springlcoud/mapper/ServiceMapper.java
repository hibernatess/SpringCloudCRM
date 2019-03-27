package com.ywj.springlcoud.mapper;

import com.ywj.springcloud.entities.Service;
import com.ywj.springlcoud.sql.SqlService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ServiceMapper {

    /**
    * 添加服务（创建服务）
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/24 11:31
    */
    @Insert("INSERT INTO cst_service (svr_type,svr_title,svr_cust_no,svr_cust_name,svr_request,svr_create_id,svr_create_by,svr_create_date)VALUES(#{svr_type},#{svr_title},#{svr_cust_no},#{svr_cust_name},#{svr_request},#{svr_create_id},#{svr_create_by},#{svr_create_date})")
    int addService(Service service);


    /**
    * 多条件查询
     * SelectProvider type找到对应的类  method使用次类里面的方法做sql语句 进行数据库的操作
    * @author      hhh
    * @return      返回server的集合
    * @exception
    * @date        2019/3/24 14:45
    */
    @SelectProvider(type =SqlService.class,method = "findServerMultiple")
    List<Map<String,Object>> findServerMultiple(String svr_cust_name, String svr_title, String svr_type, String svr_status, String begindate, String enddate);



    /**
    * 删除单个服务
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/24 11:30
    */
    @Delete("DELETE FROM cst_service WHERE svr_id=#{svr_id}")
    int deleteService(Integer svr_id);


    /**
    * 处理新创建的服务  改成已分配 分配给那个员工(id,name)修改分配时间
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/24 11:54
    */
    @Update("UPDATE cst_service SET svr_status='已分配',svr_due_id=#{svr_due_id},svr_due_to=#{svr_due_to},svr_due_date=#{svr_due_date} WHERE svr_id=#{svr_id}")
    int updateAllocation(Service service);


    /**
    * 在分配之后最处理  对分配下去的服务进行处理 根据id修改处理的结果 修改处理人  和处理时间
    * @author      hhh
    * @return
    * @exception   
    * @date        2019/3/24 14:06
    */
    @Update("UPDATE cst_service SET svr_status='已处理',svr_deal=#{ser_svr_deal},svr_deal_id=#{svr_deal_id},svr_deal_by=#{svr_deal_by},svr_deal_date=#{svr_deal_date}  WHERE svr_id=#{svr_id}")
    int updateDispose(Service service);


    /**
    * 对处理之后客户的反馈  看看是否满意  如果满意就归档  不满意返回至服务处理从新进行处理
    * @author      hhh
    * @return
    * @exception
    * @date        2019/3/24 14:13
    */
    @Update("UPDATE cst_service SET svr_status=#{svr_status},svr_result=#{svr_result},svr_satisfy=#{svr_satisfy}  WHERE svr_id=#{svr_id}")
    int updateResult(Service service);

}
