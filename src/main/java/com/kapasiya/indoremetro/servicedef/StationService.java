package com.kapasiya.indoremetro.servicedef;

import com.kapasiya.indoremetro.entity.Station;

import java.util.List;
import java.util.Optional;

public interface StationService
{
    public List<Station> getAllStations();

    public void addStations(Station products);

    public void deleteStationByID(int id);

    public Optional<Station> findStationById(int id);

}
