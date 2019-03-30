package com.ywj.springlcoud.service;


import com.ywj.springcloud.entities.Chance;
import com.ywj.springcloud.entities.Plan;
import com.ywj.springlcoud.sql.SqlOrders;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface OrderService {
    /**
     * 历史订单
     */
    List<Map<String,Object>> listOrder(String odr_cust_id);

    /**
     * 历史订单详情
     */
    List<Map<String,Object>> findOrder(String odd_order_id);

    /**
     * 总价格
     */
    List<Map<String,Object>> findSum(String odd_order_id);

}
