package com.example.Project_2.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // Hardcoded user list
    private List<Map<String, Object>> users = List.of(
            Map.of("id", 1, "name", "Alberto Admin", "email", "albergarcia@csumb.edu", "role", "ADMIN"),
            Map.of("id", 2, "name", "Bob User", "email", "bob@example.com", "role", "USER"),
            Map.of("id", 3, "name", "Charlie User", "email", "charlie@example.com", "role", "USER")
    );

    @GetMapping("/users")
    public List<Map<String, Object>> getAllUsers() {
        return users;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("User with ID " + id + " deleted.");
        return "User with ID " + id + " deleted (not persisted yet)";
    }
}
