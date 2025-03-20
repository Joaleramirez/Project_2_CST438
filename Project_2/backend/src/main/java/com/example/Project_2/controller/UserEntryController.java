package com.example.Project_2.controller;

import com.example.Project_2.models.UserEntry;
import com.example.Project_2.models.TierList;
import com.example.Project_2.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    // View all user entries for a specific user (updated the return type)
    @GetMapping("/{userId}")
    public ResponseEntity<List<UserEntry>> getUserEntries(@PathVariable Long userId) {
        return ResponseEntity.ok(userEntryService.getUserEntries(userId)); // Make sure this returns List<UserEntry>
    }

    // Get a user entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntry> getUserEntryById(@PathVariable Long id) {
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
    public ResponseEntity<Void> deleteUserEntry(@PathVariable Long id) {
        userEntryService.deleteUserEntry(id);
        return ResponseEntity.noContent().build();
    }
}
