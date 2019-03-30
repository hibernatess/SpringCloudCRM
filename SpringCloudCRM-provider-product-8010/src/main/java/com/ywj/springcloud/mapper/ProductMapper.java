package com.ywj.springcloud.mapper;


import com.ywj.springcloud.sql.SqlProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProductMapper {
    /**
     * 多条件查询产品信息
     */
    @SelectProvider(type = SqlProduct.class,method = "listProduct")
    List<Map<String, Object>> listProduct(String prod_name, String prod_type, String prod_batch);
    /**
    * 多条件查询库存信息
     */
    @SelectProvider(type = SqlProduct.class,method = "listStorage")
    List<Map<String, Object>> listStorage(String prod_name, String stk_warehouse);

}
