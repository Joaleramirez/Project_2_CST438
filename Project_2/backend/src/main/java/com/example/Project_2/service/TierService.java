package com.example.Project_2.services;

import com.example.Project_2.models.Tier;
import com.example.Project_2.repositories.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TierService {
    @Autowired
    private TierRepository tierRepository;

    public List<Tier> getAllTiers() {
        return tierRepository.findAll();
    }

    public Optional<Tier> getTierById(Integer id) {
        return tierRepository.findById(id);
    }

    public Tier createTier(Tier tier) {
        return tierRepository.save(tier);
    }

    public void deleteTier(Integer id) {
        tierRepository.deleteById(id);
    }
}
