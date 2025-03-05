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
        // Get attributes (immutable map)
        Map<String, Object> attributes = authentication.getPrincipal().getAttributes();

        // Copy to a mutable HashMap
        Map<String, Object> userAttributes = new HashMap<>(attributes);

        // Manually set isNewUser for testing
        String email = (String) userAttributes.get("email");

        // Change this email for testing purposes
        boolean isNewUser = email.equals("alberto67497@gmail.com"); // Simulated condition

        userAttributes.put("isNewUser", isNewUser);

        return userAttributes;
    }
}
