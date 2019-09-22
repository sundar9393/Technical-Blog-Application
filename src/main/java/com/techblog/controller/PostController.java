package com.techblog.controller;

import com.techblog.model.BlogPost;
import com.techblog.model.Category;
import com.techblog.model.User;
import com.techblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping("/posts")
    public String getUserPosts(Model model){
       List<BlogPost> posts = blogPostService.getUserPosts();
       model.addAttribute("posts",posts);
       return "posts";
    }
    @RequestMapping("posts/create")
    public String createPost() {
        return "posts/create";
    }

    @RequestMapping(value = "posts/create", method = RequestMethod.POST)
    public String submitPost(BlogPost newPost, HttpSession session) {
        User loggedUser = (User)session.getAttribute("loggedInUser");
        newPost.setUser(loggedUser);
        if(newPost.getSpringBlog()!=null){
            Category springCategory = new Category();
            springCategory.setCategory(newPost.getSpringBlog());
            newPost.getCategories().add(springCategory);
        }
        if(newPost.getJavaBlog()!=null) {
            Category javaCategory = new Category();
            javaCategory.setCategory(newPost.getJavaBlog());
            newPost.getCategories().add(javaCategory);
        }

        blogPostService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model) {
        BlogPost post = blogPostService.getPost(postId);
        model.addAttribute("post",post);
        return "posts/edit";
    }

    @RequestMapping(value= "/editPost", method = RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, BlogPost post, HttpSession session) {
        User loggedUser = (User)session.getAttribute("loggedInUser");
        post.setUser(loggedUser);
        post.setId(postId);
        blogPostService.updatePost(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.DELETE)
    public String deletePost(@RequestParam(name="postId") Integer postId) {
        blogPostService.deletePost(postId);
        return "redirect:/posts";
    }



}
