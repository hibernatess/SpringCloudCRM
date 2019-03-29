package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 交往记录表交往记录表
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class Activity {
	/**
	 * 交往记录ID: 主键 标识列
	 */
	private Long atv_id;
	/**
	 * 客户编号: 外键 cst_customer(cust_no)
	 */
	private String atv_cust_no;
	/**
	 * 客户名称
	 */
	private String atv_cust_name;
	/**
	 * 交往日期: 默认系统当前时间
	 */
	private Date atv_date;
	/**
	 * 交往地点
	 */
	private String atv_place;
	/**
	 * 概要
	 */
	private String atv_title;
	/**
	 * 备注
	 */
	private String atv_remark;
	/**
	 * 详细
	 */
	private String atv_desc;

}
