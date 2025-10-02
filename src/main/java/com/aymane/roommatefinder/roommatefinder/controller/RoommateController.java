package com.aymane.roommatefinder.roommatefinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aymane.roommatefinder.roommatefinder.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList; 


import org.springframework.web.bind.annotation.GetMapping;
import com.aymane.roommatefinder.roommatefinder.model.User;
import java.util.List;


@RestController
@RequestMapping("/api/roommates")
public class RoommateController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/search")
    public List<User> searchRoommates(@RequestParam(required = false) Integer minBudget, @RequestParam(required = false) Integer maxBudget) {
        if (minBudget == null && maxBudget == null) {
            return userRepository.findAll();
        }

        List<User> allUsers = userRepository.findAll();
        List<User> matchingUsers = new ArrayList<>();

        for (User user : allUsers) {
            if (user.getMinBudget() != null && user.getMaxBudget() != null) {
                if (user.getMinBudget() <= maxBudget && user.getMaxBudget() >= minBudget) {
                    matchingUsers.add(user);
                }
            }
        }

        return matchingUsers;
    }



}