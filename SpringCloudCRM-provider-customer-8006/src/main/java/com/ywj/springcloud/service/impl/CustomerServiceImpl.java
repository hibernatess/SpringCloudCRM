package com.ywj.springcloud.service.impl;

import com.ywj.springcloud.entities.Customer;
import com.ywj.springcloud.maapper.CustomerMapper;
import com.ywj.springcloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<Map<String, Object>> findChanceMultiple(String cust_status, String cust_name) {
        return customerMapper.findChanceMultiple(cust_status,cust_name);
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public int editCustomer(Customer customer) {
        return customerMapper.editCustomer(customer);
    }

    @Override
    public int editStatus(Customer customer) {
        return customerMapper.editCustomer(customer);
    }
}
