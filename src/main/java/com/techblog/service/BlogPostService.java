package com.techblog.service;

import com.techblog.model.BlogPost;
import com.techblog.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private PostRepo repo;

    public List<BlogPost> getAllPosts(){

        return repo.getAllPosts();
    }

    public List<BlogPost> getUserPosts(){
        List<BlogPost> posts = repo.getAllPosts();
        return posts;
    }

    public void createPost(BlogPost post){
        post.setDate(new Date());
        repo.createPost(post);
    }

    public BlogPost getPost(Integer id) {
        return repo.getPost(id);
    }

    public void updatePost(BlogPost updatedPost) {
        updatedPost.setDate(new Date());
        repo.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        repo.deletePost(postId);
    }


}
