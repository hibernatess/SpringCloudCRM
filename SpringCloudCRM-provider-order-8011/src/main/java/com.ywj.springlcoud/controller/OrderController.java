package com.ywj.springlcoud.controller;


import com.ywj.springlcoud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 查询历史订单
     */
    @GetMapping("/listOrder")
    public List<Map<String,Object>> listOrder(String  odr_cust_id){
        List<Map<String,Object>> listOrder = orderService.listOrder(odr_cust_id);
        return listOrder;
    }

    /**
     * 查找订单详情
     */
    @GetMapping("/findOrder")
    public List<Map<String,Object>> findOrder(String odd_order_id){
        List<Map<String,Object>> findOrder = orderService.findOrder(odd_order_id);
        return findOrder;
    }

    /**
     * 查询总价格
     */
    @GetMapping("/findSum")
    public List<Map<String,Object>> findSum(String odd_order_id){
        List<Map<String,Object>> findSum = orderService.findSum(odd_order_id);
        return findSum;
    }
}
