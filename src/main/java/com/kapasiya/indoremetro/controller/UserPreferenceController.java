package com.kapasiya.indoremetro.controller;

import com.kapasiya.indoremetro.entity.UserPreference;
import com.kapasiya.indoremetro.servicedefinitation.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-preferences")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService userPreferenceService;

    @GetMapping
    public List<UserPreference> getAllUserPreferences() {
        return userPreferenceService.getAllUserPreferences();
    }

    @GetMapping("/{id}")
    public UserPreference getUserPreferenceById(@PathVariable Long id) {
        return userPreferenceService.getUserPreferenceById(id);
    }

    @PostMapping
    public UserPreference createUserPreference(@RequestBody UserPreference userPreference) {
        return userPreferenceService.createUserPreference(userPreference);
    }

    @PutMapping("/{id}")
    public UserPreference updateUserPreference(@PathVariable Long id, @RequestBody UserPreference userPreference) {
        return userPreferenceService.updateUserPreference(id, userPreference);
    }

    @DeleteMapping("/{id}")
    public void deleteUserPreference(@PathVariable Long id) {
        userPreferenceService.deleteUserPreference(id);
    }
}
