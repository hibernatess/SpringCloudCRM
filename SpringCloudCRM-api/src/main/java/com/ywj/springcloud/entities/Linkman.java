package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 联系人表
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class Linkman {
	/**
	 * 联系人ID:主键 标识列
	 */
	private Long lkm_id;
	/**
	 * 客户编号:外键 cst_customer(cust_no)
	 */
	private String lkm_cust_no;
	/**
	 * 客户名称
	 */
	private String lkm_cust_name;
	/**
	 * 联系人名字
	 */
	private String lkm_name;
	/**
	 * 性别:默认值'男'
	 */
	private String lkm_sex;
	/**
	 * 职位
	 */
	private String lkm_postion;
	/**
	 * 办公电话
	 */
	private String lkm_tel;
	/**
	 * 手机
	 */
	private String lkm_mobile;
	/**
	 *备注 
	 */
	private String lkm_memo;
}
