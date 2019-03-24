package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName User
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 10:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class User {
private String id;
private String usr_name;
private String usr_password;
private Integer  usr_flag;
}
