package com.example.Project_2.repositories;

import com.example.Project_2.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntryRepository extends JpaRepository<UserEntry, Integer> {}