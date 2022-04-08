package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    final
    UserMapper UserMapper;

    public UserService( UserMapper saveUserMapper) {

        this.UserMapper = saveUserMapper;
    }

    public Integer QueryId(String username){
        return UserMapper.QueryId(username);
    }

    public User QueryUser(int id){
        return UserMapper.QueryUser(id);
    }

    public String QueryRole(int id){return UserMapper.QueryRole(id);}

    public void SaveUsers(String name, String sex,Integer age, String phonenumber, String departmentname){
       UserMapper.SaveUsers(name,sex,age,phonenumber,departmentname);
    }

    public List<User> QueryUsers(){
        return UserMapper.QueryUsers();
    }

    public void UpdateUser(int id,String name,Integer age,String sex,String phonenumber,String departmentname){

         UserMapper.UpdateUser(id,name,age,sex,phonenumber,departmentname);

    }

    public void UpdateRole(int id ,String role){
        UserMapper.UpdateRole(id, role);
    }
}
