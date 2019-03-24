package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Role
 * @Author ywj
 * @Describe
 * @Date 2019/3/24 0024 11:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class Role {

    private Integer  role_id;
    private String role_name;
    private String  role_desc;
    private Integer role_flag;

}
