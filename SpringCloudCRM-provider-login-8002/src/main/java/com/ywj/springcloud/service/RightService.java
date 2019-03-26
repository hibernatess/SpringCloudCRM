package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.TreeNode;

import java.util.List;
import java.util.Map;

public interface RightService {
    /**
     * 返回树形菜单集合
     * 根据用户的角色来返回树形菜单
     * @param map 角色id
     * @return
     * @throws Exception
     */
    public List<TreeNode> menuTreeList(String role_id, String parent_code) throws Exception;




}
