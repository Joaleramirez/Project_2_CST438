package com.example.Project_2.services;

import com.example.Project_2.models.UserEntry;
import com.example.Project_2.repositories.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserEntryService {
    @Autowired
    private UserEntryRepository userEntryRepository;

    public List<UserEntry> getAllUserEntries() {
        return userEntryRepository.findAll();
    }

    public Optional<UserEntry> getUserEntryById(Integer id) {
        return userEntryRepository.findById(id);
    }

    public UserEntry createUserEntry(UserEntry userEntry) {
        return userEntryRepository.save(userEntry);
    }

    public void deleteUserEntry(Integer id) {
        userEntryRepository.deleteById(id);
    }
}
