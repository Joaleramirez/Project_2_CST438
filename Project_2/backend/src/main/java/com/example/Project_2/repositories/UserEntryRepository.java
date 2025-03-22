package com.example.Project_2.repositories;

import com.example.Project_2.models.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserEntryRepository extends JpaRepository<UserEntry, Long> {
    List<UserEntry> findByUserId(Long userId); // Method to find user entries by userId
}