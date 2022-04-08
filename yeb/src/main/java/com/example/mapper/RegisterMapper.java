package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper  {


    @Insert("insert into register (username,password) values(#{username}, #{password})")
    void register(String username, String password);
//
//    @Select("select * from register where username=#{username}")
//    User registeruser(String username);

}
