package com.techblog.service;

import com.techblog.model.User;
import com.techblog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User login(User user) {
       User existingUser = userRepo.checkUser(user.getUsername(), user.getPassword());
       if(existingUser!=null){
           return existingUser;
       }
       return null;

    }

    public void registerUser(User newUser) {
        userRepo.registerUser(newUser);
    }
}
