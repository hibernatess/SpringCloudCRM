package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 营销计划表
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class Plan {
	/**
	 * 计划ID: 主键 标识列
	 */
	private Long pla_id;
	/**
	 * 营销机会ID:外键 
	 */
	private Long pla_chc_id;
	/**
	 * 计划执行日期
	 */
	private String pla_date;
	/**
	 * 计划内容
	 */
	private String pla_todo;
	/**
	 * 计划执行结果
	 */
	private String pla_result;

}
