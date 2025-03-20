package com.example.Project_2.controller;

import com.example.Project_2.models.Tier;
import com.example.Project_2.service.TierService;
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

@RestController
@RequestMapping("/tiers")
public class TierController {
    @Autowired
    private TierService tierService;

    // Get all tiers
    @GetMapping
    public List<Tier> getAllTiers() {
        return tierService.getAllTiers();
    }

    // Get a tier by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tier> getTierById(@PathVariable Long id) {
        return tierService.getTierById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new tier
    @PostMapping
    public Tier createTier(@RequestBody Tier tier) {
        return tierService.createTier(tier);
    }

    // Delete a tier by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTier(@PathVariable Long id) {
        tierService.deleteTier(id);
        return ResponseEntity.noContent().build();
    }
}