package com.example.Project_2.service;

import com.example.Project_2.models.TierItem;
import com.example.Project_2.repository.TierItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TierItemService {
    private final TierItemRepository tierItemRepository;

    public TierItemService(TierItemRepository tierItemRepository) {
        this.tierItemRepository = tierItemRepository;
    }

    public List<TierItem> getItemsByTierListId(Long tierListId) {
        return tierItemRepository.findByTierListId(tierListId);
    }

    public Optional<TierItem> getTierItemById(Long id) {
        return tierItemRepository.findById(id);
    }

    public TierItem createTierItem(TierItem tierItem) {
        return tierItemRepository.save(tierItem);
    }

    public void deleteTierItem(Long id) {
        tierItemRepository.deleteById(id);
    }
}
