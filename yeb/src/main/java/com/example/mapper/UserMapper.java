package com.example.mapper;


import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface UserMapper {

    //    个人信息的添加
    @Insert("insert into user (age,name,sex,phonenumber,departmentname) values(#{age},#{name},#{sex},#{phonenumber},#{departmentname})")
    void SaveUsers(String name, String sex, Integer age, String phonenumber, String departmentname);

    //    根据id查询用户名
    @Select("select id from register where username=#{username}")
    Integer QueryId(String username);

    //    根据id查询用户信息
    @Select("select * from user where id=#{id}")
    User QueryUser(int id);

    //    根据id查询用户角色
    @Select("select role from user where id=#{id}")
    String QueryRole(int id);

    //    查询所有用户信息
    @Select("select * from user")
    List<User> QueryUsers();

    //根据id修改用户角色
    @Update("update user set role=#{role} where id=#{id}")
    void UpdateRole(int id, String role);

    //    根据id修改用户信息
    @Update("update user set name=#{name},age=#{age},sex=#{sex},phonenumber=#{phonenumber},departmentname=#{departmentname} where id=#{id}")
    void UpdateUser(int id, String name, Integer age, String sex, String phonenumber, String departmentname);
}



