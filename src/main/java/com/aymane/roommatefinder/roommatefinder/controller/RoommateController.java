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
    public List<User> searchRoommates(@RequestParam(required = false) Integer minBudget,
                                      @RequestParam(required = false) Integer maxBudget,
                                      @RequestParam(required = false) String preferredNeighborhoods) {
        if (minBudget == null && maxBudget == null && preferredNeighborhoods == null) {
            return userRepository.findAll();
        }

        List<User> allUsers = userRepository.findAll();
        List<User> matchingUsers = new ArrayList<>();

        for (User user : allUsers) {
            boolean budgetMatches = true;
            boolean neighborhoodMatches = true;

            // Only check budget if search parameters were provided
            if (minBudget != null && maxBudget != null) {
                if (user.getMinBudget() != null && user.getMaxBudget() != null) {
                    budgetMatches = user.getMinBudget() <= maxBudget && user.getMaxBudget() >= minBudget;
                } else {
                    budgetMatches = false;
                }
            }
            // Only check neighborhood if search parameter was provided
            if (preferredNeighborhoods != null) {
                if (user.getPreferredNeighborhoods() != null && user.getPreferredNeighborhoods().equals(preferredNeighborhoods)) {
                    neighborhoodMatches = true;
                } else {
                    neighborhoodMatches = false;
                }
            }
            if (budgetMatches && neighborhoodMatches) {
                matchingUsers.add(user);
            }
        }

        return matchingUsers;
    }



}