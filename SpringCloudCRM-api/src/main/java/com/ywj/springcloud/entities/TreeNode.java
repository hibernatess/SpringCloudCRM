package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TreeNode
 * @Author ywj
 * @Describe
 * @Date 2019/3/26 0026 9:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor//无参的构造函数
@Accessors(chain = true)//是否开启链式访问
public class TreeNode {
    private String spread;
    private String id;
    private String name;
    //描述父子节点，用于递归子节点
    private List<TreeNode> children = new ArrayList<>();
    //树形菜单的节点，除了ID以及展示文本，可能还伴有跳转页面或者图片展示，等等一系列的描述
    //都将其放入到map集合中
    private Map<String, Object> attributes = new HashMap<>();







}
