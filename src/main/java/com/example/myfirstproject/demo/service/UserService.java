package com.example.myfirstproject.demo.service;

import com.example.myfirstproject.demo.dto.UserRequest;
import com.example.myfirstproject.demo.model.User;
import com.example.myfirstproject.demo.repository.UserRepository;
import com.example.myfirstproject.demo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        try {
            User user = new User();
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    public User getUserById(Long id) {
        try {
            return userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching user: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> userList;
        try {
            userList = userRepository.findAll();
            System.out.println(userList);
            if (userList.isEmpty()) {
                throw new UserNotFoundException("No users found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching users: " + e.getMessage());
        }
        return userList;
    }
}
