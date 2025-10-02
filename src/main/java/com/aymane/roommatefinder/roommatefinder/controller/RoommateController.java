package com.aymane.roommatefinder.roommatefinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aymane.roommatefinder.roommatefinder.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import com.aymane.roommatefinder.roommatefinder.model.User;
import java.util.List;

@RestController
@RequestMapping("/api/roommates")
public class RoommateController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/search")
    public List<User> searchRoommates() {
        return userRepository.findAll();
    }




}