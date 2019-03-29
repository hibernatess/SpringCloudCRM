package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 营销机会表
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class Chance {
    /**
     * 营销机会ID:主键 标识列
     */
	private Long chc_id; 
	/**
     * 机会来源
     */
	private String chc_source;
	/**
     * 客户名称
     */
	private String chc_cust_name;
	/**
     * 概要
     */
	private String chc_title;
	/**
     * 成功机率
     */
	private Integer chc_rate;
	/**
     * 联系人
     */
	private String chc_linkman;
	/**
     * 联系人电话
     */
	private String chc_tel;
	/**
     * 机会描述
     */
	private String chc_desc;
	/**
     * 创建人ID: 引用sys_user(usr_id)chc_create_id
     */
	private Long chc_create_id;
	/**
     * 创建人名字
     */
	private String chc_create_by;
	/**
     * 创建日期时间
     */
	private String chc_create_date;
	/**
     * 指派给-某人ID
     */
	private Long chc_due_id;
	/**
     * 指派给-某人名字
     */
	private String chc_due_to;
	/**
     * 指派日期时间
     */
	private String chc_due_date;
	/**
     * 状态: 1 未指派 2 已指派(或开发中) 3 开发成功 4 开发失败
     */
	private String chc_status;
}
