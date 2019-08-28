package com.techblog.controller;

import com.techblog.model.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model) {

        BlogPost post1 = new BlogPost();
        post1.setTitle("Post1");
        post1.setBody("This is the first post of the tech blog");
        post1.setDate(new Date());

        BlogPost post2 = new BlogPost();
        post2.setTitle("Post2");
        post2.setBody("This is the second post of the tech blog");
        post2.setDate(new Date());

        BlogPost post3 = new BlogPost();
        post3.setTitle("Post1");
        post3.setBody("This is the third post of the tech blog");
        post3.setDate(new Date());

        ArrayList<BlogPost> posts = new ArrayList<>();

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        model.addAttribute("posts", posts);

        return "index";
    }
}