package com.gjh.controller;

import com.gjh.bean.User;
import com.gjh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String userlist(HttpServletRequest request) {
        List<User> userList = userService.selectAll();
        request.setAttribute("userlist", userList);
        return "userlist";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String Add(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.insert(user);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    public String del(@PathVariable Integer id) {
        userService.deleteByPrimaryKey(id);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/upd",method = RequestMethod.PUT)
    public String upd(User user) {
        userService.updateByPrimaryKey(user);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/upd1")
    public String upd1(HttpServletRequest request) {
        User user = userService.selectByPrimaryKey(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", user);
        return "update";
    }
}
