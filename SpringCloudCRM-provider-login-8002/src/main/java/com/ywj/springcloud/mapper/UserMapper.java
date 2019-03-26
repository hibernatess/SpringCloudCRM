package com.ywj.springcloud.mapper;

import com.ywj.springcloud.entities.TreeNode;
import com.ywj.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

     User loadUserLogin(User user);

     List<Map<String,Object>> loadRight( String role_id, String parent_code);

}
