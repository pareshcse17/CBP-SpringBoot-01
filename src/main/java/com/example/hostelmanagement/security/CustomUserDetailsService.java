package com.example.hostelmanagement.security;

import com.example.hostelmanagement.entity.Users;
import com.example.hostelmanagement.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// This service loads user details for authentication
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Users user = usersRepo.findByEmailAddress(emailAddress)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + emailAddress));
        return new CustomUserDetails(user);
    }
}
