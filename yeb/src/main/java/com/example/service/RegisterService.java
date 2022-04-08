package com.example.service;

import com.example.mapper.RegisterMapper;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

   final
   RegisterMapper registerMapper;


    public RegisterService(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;

    }

    public boolean register(String username, String password) {


        if (username != null) {
            System.out.println(registerMapper == null);
            assert registerMapper != null;
            registerMapper.register(username, password);
            System.out.println("注册成功！");
            return true;
        } else {
            return false;
        }


    }
}
