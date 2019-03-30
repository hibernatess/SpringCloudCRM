package com.ywj.springcloud.controller;


import com.ywj.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    /**
     * 查询产品信息
     */
    @GetMapping("/listProduct")
    public List<Map<String,Object>> listProduct(String prod_name, String prod_type, String prod_batch){
        List<Map<String,Object>> listProduct = productService.listProduct( prod_name, prod_type, prod_batch);
        return listProduct;
    }
    /**
     * 查询库存信息
     */
    @GetMapping("/listStorage")
    public List<Map<String,Object>> listStorage(String prod_name, String stk_warehouse) {
        List<Map<String,Object>> listStorage = productService.listStorage( prod_name, stk_warehouse);
        return listStorage;
    }
}
