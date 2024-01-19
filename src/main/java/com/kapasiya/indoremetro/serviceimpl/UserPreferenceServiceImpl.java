package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.UserPreference;
import com.kapasiya.indoremetro.repo.UserPreferenceRepository;
import com.kapasiya.indoremetro.servicedefinitation.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    @Override
    public List<UserPreference> getAllUserPreferences() {
        return userPreferenceRepository.findAll();
    }

    @Override
    public UserPreference getUserPreferenceById(Long id) {
        return userPreferenceRepository.findById(id).orElse(null);
    }

    @Override
    public UserPreference createUserPreference(UserPreference userPreference) {
        // Additional validation or business logic can be added here
        return userPreferenceRepository.save(userPreference);
    }

    @Override
    public UserPreference updateUserPreference(Long id, UserPreference userPreference) {
        // Additional validation or business logic can be added here
        userPreference.setId(id);
        return userPreferenceRepository.save(userPreference);
    }

    @Override
    public void deleteUserPreference(Long id) {
        userPreferenceRepository.deleteById(id);
    }
}