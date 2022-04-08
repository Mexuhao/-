package com.example.controller;

import com.example.service.LoginService;
import com.example.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class IndexController {
    public final LoginService loginService;
    public final RegisterService registerService;
   static String username;

    public IndexController(LoginService loginService, RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    //进入首页
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String index() {
        return "/index";
    }

    //实现登录
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request,  Model model, HttpSession httpSession) {
        username = request.getParameter("username");

        String password = loginService.login(username);
        System.out.println("用户名为：" + username);
        System.out.println("查询到的密码为：" + password);

        if (password.equals(request.getParameter("password"))) {
            httpSession.setAttribute("User", username);
            return "/office";
        } else {
//            model.addAttribute("msg", "用户名或者密码错误");
            return "/index";
        }


    }



    //    注册
    @PostMapping(value = "/register")
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("注册的用户名为："+ username);
        System.out.println("注册的密码为:"+password);
        System.out.println( registerService == null);
        boolean t = registerService.register(username, password);
        System.out.println("------");
        System.out.println(t);
        return "redirect:/";


    }

    @RequestMapping(value = "/registerPage", method = {RequestMethod.GET})
    public String registerPage() {

        return "/register";
    }


}

