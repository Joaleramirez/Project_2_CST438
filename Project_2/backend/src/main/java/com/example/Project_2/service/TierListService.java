package com.example.Project_2.service;

import com.example.Project_2.models.TierList;
import com.example.Project_2.repository.TierListRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TierListService {
    private final TierListRepository tierListRepository;

    public TierListService(TierListRepository tierListRepository) {
        this.tierListRepository = tierListRepository;
    }

    public List<TierList> getTierListsByUserId(Long userId) {
        return tierListRepository.findByUserId(userId);
    }

    public Optional<TierList> getTierListById(Long id) {
        return tierListRepository.findById(id);
    }

    public TierList createTierList(TierList tierList) {
        return tierListRepository.save(tierList);
    }

    public void deleteTierList(Long id) {
        tierListRepository.deleteById(id);
    }
}
