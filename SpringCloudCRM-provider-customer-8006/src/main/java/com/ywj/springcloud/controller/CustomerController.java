package com.ywj.springcloud.controller;


import com.ywj.springcloud.entities.Customer;
import com.ywj.springcloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    /**
     * 查询全部客户
     */
    @GetMapping("/findCustomerMultiple")
    public  List<Map<String,Object>> fundCustomerAll(String cust_status, String cust_name){
        List<Map<String,Object>> customerMultiple = customerService.findChanceMultiple( cust_status,  cust_name);
        return customerMultiple;
    }

    /**
     * 添加客户
     */
    @RequestMapping("/addCustomer")
    public  int addCustomer(Customer customer){
            int i = customerService.addCustomer(customer);
            return i;
    }

    /**
     * 编辑客户信息
     */
    @RequestMapping("/editCustomer")
    public int editCustomer(Customer customer){
        int i = customerService.editCustomer(customer);
        return i;
    }
    /**
     * 用于查询客户做下拉框
     */
    public List<Map<String,Object>> findCust(){
            List<Map<String, Object>> customerAll = customerService.findChanceMultiple(null, null);
            return customerAll;
    }
}
