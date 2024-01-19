package com.kapasiya.indoremetro.servicedefinitation;

import com.kapasiya.indoremetro.entity.UserPreference;

import java.util.List;

public interface UserPreferenceService {
    List<UserPreference> getAllUserPreferences();
    UserPreference getUserPreferenceById(Long id);
    UserPreference createUserPreference(UserPreference userPreference);
    UserPreference updateUserPreference(Long id, UserPreference userPreference);
    void deleteUserPreference(Long id);
}