package com.kapasiya.indoremetro.repo;

import com.kapasiya.indoremetro.entity.MetroRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroRouteRepository extends JpaRepository<MetroRoute, Long> {
    // Additional custom queries can be added here if needed
}