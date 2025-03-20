package com.example.Project_2.service;

import com.example.Project_2.models.TierList;
import com.example.Project_2.repository.TierListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TierListService {
    @Autowired
    private TierListRepository tierListRepository;

    public List<TierList> getAllTierLists() {
        return tierListRepository.findAll();
    }

    public Optional<TierList> getTierListById(Integer id) {
        return tierListRepository.findById(id);
    }

    public TierList createTierList(TierList tierList) {
        return tierListRepository.save(tierList);
    }

    public void deleteTierList(Integer id) {
        tierListRepository.deleteById(id);
    }
}