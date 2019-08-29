package com.techblog.service;

import com.techblog.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class BlogPostService {

    public ArrayList<BlogPost> getAllPosts(){

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

        return posts;
    }
}
