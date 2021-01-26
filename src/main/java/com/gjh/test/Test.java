package com.gjh.test;

import com.gjh.bean.User;
import com.gjh.service.UserServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
//        List<User> userList = userService.selectAll();
//        System.out.println(userList);
        User user=new User();
        user.setName("name");
        user.setAge(10);
        userService.insert(user);
    }
}
