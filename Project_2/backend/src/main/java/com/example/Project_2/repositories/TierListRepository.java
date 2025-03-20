package com.example.Project_2.repositories;

import com.example.Project_2.models.TierList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TierListRepository extends JpaRepository<TierList, Long> {
    List<TierList> findByUserId(Long userId);
}
