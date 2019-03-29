package com.ywj.springcloud.maapper;


import com.ywj.springcloud.entities.Customer;
import com.ywj.springcloud.sql.SqlCustomer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CustomerMapper {
    /**
     * 查询全部
     */
    @SelectProvider(type = SqlCustomer.class,method = "findChanceMultiple")
    List<Map<String,Object>> findChanceMultiple(String cust_status, String cust_name);

    /**
     *增加客户信息
     * @return
     */
    @Insert(" INSERT INTO cst_customer (cust_no,cust_name)  VALUES(#{cust_no},#{cust_name}")
    int addCustomer(Customer customer);

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    @Update("UPDATE cst_customer SET cust_name = #{cust_name}, cust_region = #{cust_region}, cust_manager_id = #{cust_manager_id}, cust_manager_name = #{cust_manager_name}, cust_level = #{cust_level}, "+
            "  cust_level_label = #{cust_level_label}, cust_satisfy = #{cust_satisfy}, cust_credit = #{cust_credit}, cust_addr = #{cust_addr}, cust_zip =#{cust_zip}?, cust_tel = #{cust_tel}, cust_fax = #{cust_fax}, cust_website = #{cust_website},"+
            "  cust_licence_no = #{cust_licence_no}, cust_chieftain = #{cust_chieftain}, cust_bankroll = #{cust_bankroll}, cust_turnover = #{cust_turnover}, cust_bank = #{cust_bank}, cust_bank_account = #{cust_bank_account}, cust_local_tax_no = #{cust_local_tax_no}," +
            "  cust_national_tax_no = #{cust_national_tax_no} WHERE cust_no = #{cust_no}")
    int editCustomer(Customer customer);

    /**
     * 修改客户状态: 默认值 1 正常 2 非正常 数据字典(客户状态)
     * @param customer
     * @return
     */
    @Update("UPDATE cst_customer SET cust_status=#{cust_status} WHERE cust_no=#{cust_no}")
    int editStatus(Customer customer);

}
