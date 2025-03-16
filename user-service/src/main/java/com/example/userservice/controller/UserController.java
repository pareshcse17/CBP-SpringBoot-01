package com.example.userservice.controller;

import com.example.userservice.model.User;
import com.example.userservice.service.UserManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return userManager.getAllUsers().values();
    }

    @PostMapping
    public User createUser(@RequestBody String name) {
        return userManager.createUser(name);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userManager.getUserById(id);
    }

    @GetMapping("/user-service-endpoint")
    public String getUserData() {
        return "User Data from UserService";
    }
}
