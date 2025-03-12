package com.example.Project_2.repository;

import com.example.Project_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //Interfaces for database operations
    //Examples
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
