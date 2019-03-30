package com.ywj.springcloud.service.impl;

import com.ywj.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductService productService;
    @Override
    public List<Map<String, Object>> listProduct(String prod_name, String prod_type, String prod_batch) {
        return productService.listProduct(prod_name,prod_type,prod_batch);
    }

    @Override
    public List<Map<String, Object>> listStorage(String prod_name, String stk_warehouse) {
        return productService.listStorage(prod_name,stk_warehouse);
    }
}
