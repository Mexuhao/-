package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserManagerController {
    final
    UserService userService;

    public UserManagerController(UserService userService) {
        this.userService = userService;
    }

    //    查询所有员工
    @RequestMapping(value = "/login/usermanager", method = {RequestMethod.POST, RequestMethod.GET})
    public String QueryUsers(Model model) {
        String username = IndexController.username;
        if ("admin".equals(username)) {
            List<User> list = userService.QueryUsers();
            model.addAttribute("lists", list);
            return "/usermanager";
        } else {
            model.addAttribute("msg", "权限不足");
            return "users";
        }

    }

    //更新员工信息
    @ResponseBody
    @RequestMapping(value = "/login/updateuser", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateUser(String name, String sex, Integer age, String phonenumber, String departmentname) {
        String username = IndexController.username;
        int id = userService.QueryId(username);
        System.out.println(name);
        userService.UpdateUser(id, name, age, sex, phonenumber, departmentname);
        System.out.println(IndexController.username);
        return "修改成功";
    }

    @ResponseBody
    @PostMapping(value = "/login/updaterole")
    public void UpdateRole(String id,String role) {
        int Id=Integer.parseInt(id);
       String rolename= userService.QueryRole(Id);
       if (!rolename.equals(role))
       {
           userService.UpdateRole(Id,role);
       }
        System.out.println(role);

    }

}
