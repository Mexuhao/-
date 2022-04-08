package com.example.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//User对应IndexController中的httpSession.setAttribute("User", username);
        String loginUser = (String) request.getSession(false).getAttribute("User");
        if (loginUser == null) {
            System.out.println("111");
            response.sendRedirect("/");
            return false;
        }else {
            return true;
        }


    }
}
