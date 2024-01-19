package com.kapasiya.indoremetro.repo;

import com.kapasiya.indoremetro.entity.MetroStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroStationRepository extends JpaRepository<MetroStation, Long> {
    // Additional custom queries can be added here if needed
}