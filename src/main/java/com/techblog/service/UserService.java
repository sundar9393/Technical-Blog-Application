package com.techblog.service;

import com.techblog.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean login(User user) {
        if(user.getUsername().equals("validuser") && user.getPassword().equals("jack")){
            return true;
        }
        else {
            return false;
        }
    }
}
