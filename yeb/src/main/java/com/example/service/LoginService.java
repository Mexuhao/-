package com.example.service;

import com.example.mapper.LoginMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    final
    LoginMapper loginMapper;

    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;

    }


    public String login(String username) {
        return loginMapper.login(username);
    }

}
