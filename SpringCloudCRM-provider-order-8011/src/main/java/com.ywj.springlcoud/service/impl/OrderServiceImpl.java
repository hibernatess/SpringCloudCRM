package com.ywj.springlcoud.service.impl;

import com.ywj.springlcoud.mapper.OrderMapper;
import com.ywj.springlcoud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> listOrder(String odr_cust_id) {
        return orderMapper.listOrder(odr_cust_id);
    }

    @Override
    public List<Map<String, Object>> findOrder(String odd_order_id) {
        return orderMapper.findOrder(odd_order_id);
    }

    @Override
    public List<Map<String, Object>> findSum(String odd_order_id) {
        return orderMapper.findSum(odd_order_id);
    }
}
