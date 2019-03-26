package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Dict
 * @Author ywj
 * @Describe
 * @Date 2019/3/26 0026 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class Dict {
    //字典ID: 主键 标识列
    private Integer dict_id;
    //字典类型
    private String dict_type;
    //字典条目: 一般用来生成下拉框的文本
    private String dict_item;
    //字典值: 一般用来生成下拉框的值
    private String dict_value;
     //能否编辑: 1 可 0 不可
    private Integer dict_is_editable;
}
