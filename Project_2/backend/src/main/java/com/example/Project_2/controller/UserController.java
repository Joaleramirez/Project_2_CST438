package com.example.Project_2.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
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
}
