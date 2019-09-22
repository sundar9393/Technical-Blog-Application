package com.techblog.repository;

import com.techblog.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepo {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public void registerUser(User newUser) {
        EntityManager emgr = emf.createEntityManager();
        EntityTransaction transaction = emgr.getTransaction();

        try {
            transaction.begin();
            emgr.persist(newUser);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public User checkUser(String userName, String password) {
        EntityManager emgr = emf.createEntityManager();
        TypedQuery<User> query = emgr.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", userName);
        query.setParameter("password", password);
        try {
            User returnedUser = query.getSingleResult();
            return returnedUser;
        } catch (NoResultException e) {
            return null;
        }
    }
}
