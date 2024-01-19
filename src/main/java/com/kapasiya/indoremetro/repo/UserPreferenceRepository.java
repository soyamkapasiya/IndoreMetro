package com.kapasiya.indoremetro.repo;

import com.kapasiya.indoremetro.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    // Additional custom queries can be added here if needed
}