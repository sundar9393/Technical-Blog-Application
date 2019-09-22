package com.techblog.controller;

import com.techblog.model.BlogPost;
import com.techblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    BlogPostService blogPostService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {

        List<BlogPost> posts = blogPostService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
