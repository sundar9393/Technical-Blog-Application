package com.techblog.controller;

import com.techblog.model.User;
import com.techblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }
    @RequestMapping("users/register")
    public String registration() {
        return "users/register";
    }
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String userLogin(User user){
        if(userService.login(user)) {
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }
    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String userLogout() {
        return "redirect:/";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String registerUser(User user) {
        return "users/login";
    }

}
