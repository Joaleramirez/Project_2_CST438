package com.example.Project_2.controller;

import com.example.Project_2.models.TierItem;
import com.example.Project_2.service.TierItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tieritems")
public class TierItemController {
    private final TierItemService tierItemService;

    public TierItemController(TierItemService tierItemService) {
        this.tierItemService = tierItemService;
    }

    @GetMapping("/tierlist/{tierListId}")
    public ResponseEntity<List<TierItem>> getItemsByTierListId(@PathVariable Long tierListId) {
        return ResponseEntity.ok(tierItemService.getItemsByTierListId(tierListId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TierItem> getTierItemById(@PathVariable Long id) {
        Optional<TierItem> tierItem = tierItemService.getTierItemById(id);
        return tierItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TierItem> createTierItem(@RequestBody TierItem tierItem) {
        return ResponseEntity.ok(tierItemService.createTierItem(tierItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTierItem(@PathVariable Long id) {
        tierItemService.deleteTierItem(id);
        return ResponseEntity.noContent().build();
    }
}
