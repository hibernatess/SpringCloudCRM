package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.TreeNode;
import com.ywj.springcloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RightDao
 * @Author ywj
 * @Describe
 * @Date 2019/3/26 0026 11:15
 */
@Service
public class RightDao {
    @Autowired
    private UserMapper userMapper;
    private String role;

    /**
     * 根据角色和权限id查询菜单权限
     *
     * @return
     */
    public List<Map<String, Object>> loadRight(String role_id, String parent_code) throws Exception {
        role = role_id;
        if (StringUtils.isEmpty(parent_code)) {
            parent_code = "-1";
        }
        List<Map<String, Object>> maps = userMapper.loadRight(role_id, parent_code);
        return maps;
    }

    /**
     * 返回一个list<treenode>的集合
     *
     * @return
     * @throws Exception
     */
    public List<TreeNode> menuTreeList(String role_id, String parent_code) throws Exception {
        List<Map<String, Object>> menuList = this.loadRight(role_id, parent_code);
        List<TreeNode> TreeNodelist = new ArrayList<>();
        mapListToTreeNodeList(menuList, TreeNodelist);
        return TreeNodelist;
    }

    /**
     * 将map的list集合转换为treenode集合
     *
     * @param list
     * @param treeNodeslist
     * @throws Exception
     */
    public void mapListToTreeNodeList(List<Map<String, Object>> list, List<TreeNode> treeNodeslist) throws Exception {
        TreeNode treeNode = null;
        if (list != null) {
            for (Map<String, Object> map : list) {
                treeNode = new TreeNode();
                mapToTreeNode(map, treeNode);//给tree赋值
                treeNodeslist.add(treeNode);
            }
        }
    }

    /**
     * 将map集合转换为treenode
     *
     * @param map
     * @param treeNode
     * @throws Exception
     */
    public void mapToTreeNode(Map<String, Object> map, TreeNode treeNode) throws Exception {
        treeNode.setId(map.get("right_code").toString());
        treeNode.setName(map.get("right_text").toString());
        treeNode.setSpread("true");//默认节点打开
        treeNode.setAttributes(map);
        List<Map<String, Object>> menuList = this.loadRight(role, treeNode.getId());
        List<TreeNode> TreeNodelist = new ArrayList<>();
        // 再次遍历
        mapListToTreeNodeList(menuList, TreeNodelist);
        treeNode.setChildren(TreeNodelist);
    }


}
