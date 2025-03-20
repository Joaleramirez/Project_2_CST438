package com.example.Project_2.controllers;

import com.example.Project_2.models.TierList;
import com.example.Project_2.service.TierListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@RestController
@RequestMapping("/tier-lists")
public class TierListController {
    @Autowired
    private TierListService tierListService;

    // Get all tier lists
    @GetMapping
    public List<TierList> getAllTierLists() {
        return tierListService.getAllTierLists();
    }

    // Get a tier list by ID
    @GetMapping("/{id}")
    public ResponseEntity<TierList> getTierListById(@PathVariable Integer id) {
        return tierListService.getTierListById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new tier list
    @PostMapping
    public TierList createTierList(@RequestBody TierList tierList) {
        return tierListService.createTierList(tierList);
    }

    // Delete a tier list by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTierList(@PathVariable Integer id) {
        tierListService.deleteTierList(id);
        return ResponseEntity.noContent().build();
    }
}
