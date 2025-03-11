package com.example.Project_2.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.example.Project_2.models.User;
import com.example.Project_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // OAuth2 authentication user info
    @GetMapping("/auth")
    public Map<String, Object> getUser(OAuth2AuthenticationToken authentication) {
        System.out.println("Oauth");
        return authentication.getPrincipal().getAttributes();
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        System.out.println("Get users");
        return userService.getAllUsers();
    }

    // Create a new user
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        System.out.println("new user");
        return userService.saveUser(user);
    }
}
