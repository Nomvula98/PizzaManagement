package com.xgileit.pizzaproject.services;

import com.xgileit.pizzaproject.entities.User;
import com.xgileit.pizzaproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    /***
     * A service for registering a new user
     * */
    public String register(User user){
        List<User> userDetails = userRepository.findByUserId(user.getUserId());
        if(!userDetails.isEmpty()){
            throw new RuntimeException("User already exists!");

        }else
        {
            userRepository.save(user);
            return "Successfully registered";
        }
    }

    /***
     * A service for logging in as an existing user
     * */
    public String login(String email, String password){
        List<User> userDetails = userRepository.findByUserEmail(email);
        if(!userDetails.isEmpty()){
            return "successful login";
        }else
        {
            throw new RuntimeException("User is not registered");
        }
    }
}
