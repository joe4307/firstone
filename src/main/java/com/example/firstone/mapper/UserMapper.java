package com.example.firstone.mapper;

import com.example.firstone.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectById(Integer id);
    List<User> list();
}
