package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    /**
     * 查询全部客户信息
     */
    List<Map<String,Object>> findChanceMultiple(String cust_status, String cust_name);
    /**
     *增加客户信息
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    int editCustomer(Customer customer);

    /**
     * 修改客户状态: 默认值 1 正常 2 非正常 数据字典(客户状态)
     * @param customer
     * @return
     */
    int editStatus(Customer customer);
}
