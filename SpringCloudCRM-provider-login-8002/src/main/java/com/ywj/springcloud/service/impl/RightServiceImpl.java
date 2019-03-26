package com.ywj.springcloud.service.impl;

import com.ywj.springcloud.entities.TreeNode;
import com.ywj.springcloud.service.RightDao;
import com.ywj.springcloud.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RightServiceImpl
 * @Author ywj
 * @Describe
 * @Date 2019/3/26 0026 11:22
 */
@Service
public class RightServiceImpl implements RightService {
    @Autowired
    private RightDao rightDao;
    @Override
    public List<TreeNode> menuTreeList(String role_id, String parent_code) throws Exception {
        return rightDao.menuTreeList(role_id,parent_code);
    }
}
