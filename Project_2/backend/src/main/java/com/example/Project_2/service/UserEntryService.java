package com.example.Project_2.service;

import com.example.Project_2.models.UserEntry;
import com.example.Project_2.repositories.UserEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserEntryService {
    @Autowired
    private UserEntryRepository userEntryRepository;

    public List<UserEntry> getUserEntries(Long userId) {
        return userEntryRepository.findByUserId(userId);
    }

    public List<UserEntry> getAllUserEntries() {
        return userEntryRepository.findAll();
    }

    public Optional<UserEntry> getUserEntryById(Long id) {
        return userEntryRepository.findById(id);
    }

    public UserEntry createUserEntry(UserEntry userEntry) {
        return userEntryRepository.save(userEntry);
    }

    public void deleteUserEntry(Long id) {
        userEntryRepository.deleteById(id);
    }
}
