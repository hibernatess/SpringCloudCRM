package com.ywj.springlcoud.mapper;


import com.ywj.springlcoud.sql.SqlOrders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {
    /**
     * 历史订单
     */
    @SelectProvider(type = SqlOrders.class,method = "listOrder")
    List<Map<String,Object>> listOrder(String odr_cust_id);

    /**
     * 历史订单详情
     */
    @SelectProvider(type = SqlOrders.class,method = "findOrder")
    List<Map<String,Object>> findOrder(String odd_order_id);

    /**
     * 总价格
     */
    @SelectProvider(type = SqlOrders.class,method = "findSum")
    List<Map<String,Object>> findSum(String odd_order_id);



}
