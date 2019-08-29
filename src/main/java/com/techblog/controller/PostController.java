package com.techblog.controller;

import com.techblog.model.BlogPost;
import com.techblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping("/posts")
    public String getUserPosts(Model model){
       ArrayList<BlogPost> posts = blogPostService.getUserPosts();
       model.addAttribute("posts",posts);
       return "posts";
    }
}
