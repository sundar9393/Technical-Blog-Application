package com.techblog.repository;

import com.techblog.model.BlogPost;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepo {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<BlogPost> getAllPosts(){

        EntityManager emgr = emf.createEntityManager();
        TypedQuery<BlogPost> query = emgr.createQuery("SELECT p from BlogPost p", BlogPost.class);
        return query.getResultList();

    }

    public BlogPost getLatestPost(){

        EntityManager emgr = emf.createEntityManager();
        return emgr.find(BlogPost.class,3);

    }

    public BlogPost createPost(BlogPost newPost){
        EntityManager emgr = emf.createEntityManager();
        EntityTransaction transaction = emgr.getTransaction();
        try {
            transaction.begin();
            emgr.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return newPost;
    }

    public BlogPost getPost(Integer id) {
        EntityManager emgr = emf.createEntityManager();
        return emgr.find(BlogPost.class, id);
    }

    public void updatePost(BlogPost updatedPost) {
        EntityManager emgr = emf.createEntityManager();
        EntityTransaction transaction = emgr.getTransaction();
        try {
            transaction.begin();
            emgr.merge(updatedPost);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void deletePost(Integer postId) {
        EntityManager emgr = emf.createEntityManager();
        EntityTransaction transaction = emgr.getTransaction();
        try {
            transaction.begin();
            BlogPost post = emgr.find(BlogPost.class,postId);
            emgr.remove(post);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

}
