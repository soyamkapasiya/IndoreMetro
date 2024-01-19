package com.kapasiya.indoremetro.repo;

import com.kapasiya.indoremetro.entity.RealTimeUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealTimeUpdateRepository extends JpaRepository<RealTimeUpdate, Long> {
    // Additional custom queries can be added here if needed
}