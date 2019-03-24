package com.ywj.springcloud.mapper;

import com.ywj.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

     User loadUserLogin(User user);
}
