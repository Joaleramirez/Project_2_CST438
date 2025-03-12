package com.example.Project_2.repository;

import com.example.Project_2.models.TierItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TierItemRepository extends JpaRepository<TierItem, Long> {
    List<TierItem> findByTierListId(Long tierListId);
}
