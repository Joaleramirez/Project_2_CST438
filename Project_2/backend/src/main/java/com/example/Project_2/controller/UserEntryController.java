package com.example.Project_2.controllers;

import com.example.Project_2.models.UserEntry;
import com.example.Project_2.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

// Controller for handling user entry-related requests
@RestController
@RequestMapping("/user-entries")
public class UserEntryController {
    @Autowired
    private UserEntryService userEntryService;

    // Get all user entries
    @GetMapping
    public List<UserEntry> getAllUserEntries() {
        return userEntryService.getAllUserEntries();
    }

    // View all tier lists a user has interacted with
    @GetMapping("/{userId}")
    public ResponseEntity<List<TierList>> getUserEntries(@PathVariable int userId) {
        return ResponseEntity.ok(userEntryService.getUserEntries(userId));
    }

    // Get a user entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntry> getUserEntryById(@PathVariable Integer id) {
        return userEntryService.getUserEntryById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new user entry
    @PostMapping
    public UserEntry createUserEntry(@RequestBody UserEntry userEntry) {
        return userEntryService.createUserEntry(userEntry);
    }

    // Delete a user entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserEntry(@PathVariable Integer id) {
        userEntryService.deleteUserEntry(id);
        return ResponseEntity.noContent().build();
    }
}
