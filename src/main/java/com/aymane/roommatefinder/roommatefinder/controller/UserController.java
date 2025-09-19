package com.aymane.roommatefinder.roommatefinder.controller;

import com.aymane.roommatefinder.roommatefinder.model.User;
import com.aymane.roommatefinder.roommatefinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public String getUsers(){
        return "User controller is working";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userRepository.save(user);
        return "User registered successfully!";
    }

}