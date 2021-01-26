package com.gjh.controller;

import com.gjh.bean.User;
import com.gjh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/userlist")
    public String userlist(HttpServletRequest request) {
        List<User> userList = userService.selectAll();
        request.setAttribute("userlist", userList);
        return "userlist";
    }

    @RequestMapping(value = "/add")
    public String Add(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.insert(user);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request) {
        int id =Integer.parseInt(request.getParameter("id"));
        userService.deleteByPrimaryKey(id);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/upd")
    public String upd(HttpServletRequest request) {
        User user=new User();
        int id =Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        int age =Integer.parseInt(request.getParameter("age"));
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userService.updateByPrimaryKey(user);
        return "redirect:/userlist";
    }
    @RequestMapping(value = "/upd1")
    public String upd1(HttpServletRequest request) {
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("name",request.getParameter("name"));
        request.setAttribute("age",request.getParameter("age"));
        return "update";
    }
}
