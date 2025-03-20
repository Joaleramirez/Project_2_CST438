package com.example.Project_2.controller;

import com.example.Project_2.models.TierItem;
import com.example.Project_2.service.TierItemService;
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
@RequestMapping("/tier-items")
public class TierItemController {
    @Autowired
    private TierItemService tierItemService;

    // Get all tier items
    @GetMapping
    public List<TierItem> getAllTierItems() {
        return tierItemService.getAllTierItems();
    }

    // Get a tier item by ID
    @GetMapping("/{id}")
    public ResponseEntity<TierItem> getTierItemById(@PathVariable Long id) {
        return tierItemService.getTierItemById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new tier item
    @PostMapping
    public TierItem createTierItem(@RequestBody TierItem tierItem) {
        return tierItemService.createTierItem(tierItem);
    }

    // Delete a tier item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTierItem(@PathVariable Long id) {
        tierItemService.deleteTierItem(id);
        return ResponseEntity.noContent().build();
    }
}