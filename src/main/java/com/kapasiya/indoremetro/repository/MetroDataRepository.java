package com.kapasiya.indoremetro.repository;

import com.kapasiya.indoremetro.entity.MetroData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetroDataRepository extends JpaRepository<MetroData, Integer>
{
    @Query(value = "select * from Reservation where reservation.to_destination = :to and reservation.from_destination = :from order By reservation.filter_date desc", nativeQuery = true)
    List<MetroData> findByToFromAndDate(String to, String from);

//    @Query(value = "select * from Reservation  where reservation.to_destination =:to and reservation.from_destination =:from and reservation.filter_date =:date  order By reservation.filter_date desc " , nativeQuery = true)
//    List<MetroData> findByToFromAndDate(String to , String from, String date);
}

