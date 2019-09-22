package com.techblog.controller;

import com.techblog.model.User;
import com.techblog.model.UserProfile;
import com.techblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String registerUser(User newUser) {
        userService.registerUser(newUser);
        return "users/login";
    }

    @RequestMapping(value = "users/register")
    public String registration(Model model) {
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setUserProfile(profile);
        model.addAttribute("User",user);
        return "users/register";
    }


    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String userLogin(User user, HttpSession session){
        User existingUser = userService.login(user);
        if(existingUser!=null) {
            session.setAttribute("loggedInUser", existingUser); //adding obj to session object
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }
    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



}
