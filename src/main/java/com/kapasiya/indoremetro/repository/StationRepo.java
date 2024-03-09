package com.kapasiya.indoremetro.repository;

import com.kapasiya.indoremetro.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepo extends JpaRepository<Station,Integer>
{
//    Station findByName(String name);
}