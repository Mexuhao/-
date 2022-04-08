package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OfficeCenterController {

    public final UserService UserService;

    public OfficeCenterController(UserService UserService) {
        this.UserService = UserService;
    }


    @RequestMapping(value = "/login/users", method = {RequestMethod.POST, RequestMethod.GET})
    public String toUserPage(Model model) {
        int id = UserService.QueryId(IndexController.username);
        User user = UserService.QueryUser(id);
        model.addAttribute("us", user);
        return "users";
    }

    //根据角色跳转至不同页面
    @GetMapping(value = "login/tasks")
    public String toTasksPage() {
        int id=UserService.QueryId(IndexController.username);
        String role=UserService.QueryRole(id);
        if ("部长".equals(role)||"组长".equals(role)){
            return "/tasks";
        }
        else{
            return "/stafftasks";
        }

    }

    @GetMapping(value = "login/files")
    public String toFilePage() {
        return "/files";
    }

    @GetMapping(value = "login/communicate")
    public String toCommunicatePage() {
        return "/communicate";
    }

    @GetMapping(value = "login/exit")
    public String Exit() {

        return "/index";
    }


    @ResponseBody
    @RequestMapping(value = "/login/save", method = {RequestMethod.POST, RequestMethod.GET})
    public String saveUsers(String name, String sex, Integer age, String phonenumber, String departmentname) {
        UserService.SaveUsers(name, sex, age, phonenumber, departmentname);
        System.out.println(IndexController.username);
        if (name != null) {
            return "提交成功";
        } else {
            return "提交失败";
        }

    }

}
