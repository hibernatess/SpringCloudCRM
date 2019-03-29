package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 客户信息表
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class Customer {
	/**
	 *客户编号:主键 (建议使用自定义主键生成器自动生成,而非手动填写)KH_yyyyMMdd_00000
	 */
	private String cust_no;
	/**
	 *客户名称
	 */
	private String cust_name;
	/**
	 *地区: 数据字典(地区)
	 */
	private String cust_region;
	/**
	 *客户经理ID:默认值0
	 */
	private Long cust_manager_id;
	/**
	 *客户经理名字
	 */
	private String cust_manager_name;
	/**
	 *客户级别:默认值1 (数据字典 客户等级)
	 */
	private Integer cust_level;
	/**
	 *客户级别标志     (数据字典 客户等级)
	 */
	private String cust_level_label;
	/**
	 *客户满意度:1~5 默认值3 (数据字典 客户满意度)
	 */
	private Integer cust_satisfy;
	/**
	 *客户信用度:1~5 默认值3 (数据字典 客户信用度)
	 */
	private Integer cust_credit;
	/**
	 *地址
	 */
	private String cust_addr;
	/**
	 *邮政编码
	 */
	private String cust_zip;
	/**
	 *电话
	 */
	private String cust_tel;
	/**
	 *传真
	 */
	private String cust_fax;
	/**
	 *网站
	 */
	private String cust_website;
	/**
	 *营业执照注册号
	 */
	private Integer cust_licence_no;
	/**
	 *法人
	 */
	private String cust_chieftain;
	/**
	 *注册资金（万元）:默认值0
	 */
	private Long cust_bankroll;
	/**
	 *年营业额:默认值0
	 */
	private Long cust_turnover;
	/**
	 *开户银行
	 */
	private String cust_bank;
	/**
	 *银行帐号
	 */
	private String cust_bank_account;
	/**
	 *地税登记号
	 */
	private String cust_local_tax_no;
	/**
	 *国税登记号
	 */
	private String cust_national_tax_no;
	/**
	 *客户状态: 默认值 1 正常 2 非正常 数据字典(客户状态)
	 */
	private String cust_status;

}
