package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserManager {
    private final Map<Integer, User> userCache = new HashMap<>();
    private int currentId = 1;

    public User createUser(String name) {
        User user = new User(currentId, name);
        userCache.put(currentId, user);
        currentId++;
        return user;
    }

    public User getUserById(int id) {
        return userCache.get(id);
    }

    public Map<Integer, User> getAllUsers() {
        return userCache;
    }
}
