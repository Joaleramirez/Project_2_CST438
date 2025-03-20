package com.example.Project_2.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import com.example.Project_2.models.User;
import com.example.Project_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
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
        // Check if authentication is null (User is logged out)
        if (authentication == null) {
            return Map.of("error", "User not authenticated");
        }

        // Get attributes safely
        Map<String, Object> attributes = authentication.getPrincipal().getAttributes();
        Map<String, Object> userAttributes = new HashMap<>(attributes);

        // Simulate new user status (Modify as needed)
        String email = (String) userAttributes.get("email");
        boolean isNewUser = email.equals("alberto67497@gmail.com"); // Change this for testing

        userAttributes.put("isNewUser", isNewUser);
        return userAttributes;
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        System.out.println("Get users");
        return userService.getAllUsers();
    }

    // Create a new user
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    //Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
