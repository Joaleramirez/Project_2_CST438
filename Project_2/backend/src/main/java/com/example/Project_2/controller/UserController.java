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

        // Add simulated "isNewUser" flag (replace with actual database check later)
        userAttributes.put("isNewUser", Math.random() > 0.5); // Randomly assigns new/returning status

        return userAttributes;
    }
}

