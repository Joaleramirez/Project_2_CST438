package com.example.Project_2.controller;

import com.example.Project_2.models.TierList;
import com.example.Project_2.service.TierListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tierlists")
public class TierListController {
    private final TierListService tierListService;

    public TierListController(TierListService tierListService) {
        this.tierListService = tierListService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TierList>> getTierListsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(tierListService.getTierListsByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TierList> getTierListById(@PathVariable Long id) {
        Optional<TierList> tierList = tierListService.getTierListById(id);
        return tierList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TierList> createTierList(@RequestBody TierList tierList) {
        return ResponseEntity.ok(tierListService.createTierList(tierList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTierList(@PathVariable Long id) {
        tierListService.deleteTierList(id);
        return ResponseEntity.noContent().build();
    }
}
