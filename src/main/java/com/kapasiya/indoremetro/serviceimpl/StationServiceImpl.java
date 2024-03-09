package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.Station;
import com.kapasiya.indoremetro.repository.StationRepo;
import com.kapasiya.indoremetro.servicedef.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService
{
    @Autowired
    StationRepo stationRepo;

    @Override
    public List<Station> getAllStations() {
        return stationRepo.findAll();
    }

    @Override
    public void addStations(Station station)
    {
        stationRepo.save(station);
    }

    @Override
    public void deleteStationByID(int id)
    {
        stationRepo.deleteById(id);
    }

    @Override
    public Optional<Station> findStationById(int id) {
        return stationRepo.findById(id);
    }

}
