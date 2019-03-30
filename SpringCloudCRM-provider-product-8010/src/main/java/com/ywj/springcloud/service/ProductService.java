package com.ywj.springcloud.service;


import java.util.List;
import java.util.Map;

public interface ProductService {
    /**
     * 多条件查询产品信息
     */
    List<Map<String, Object>> listProduct(String prod_name, String prod_type, String prod_batch);
    /**
     * 多条件查询库存信息
     */
    List<Map<String, Object>> listStorage(String prod_name, String stk_warehouse);
}