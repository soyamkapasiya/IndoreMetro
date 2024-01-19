package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.MetroStation;
import com.kapasiya.indoremetro.repo.MetroStationRepository;
import com.kapasiya.indoremetro.servicedefinitation.MetroStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetroStationServiceImpl implements MetroStationService {

    @Autowired
    private MetroStationRepository metroStationRepository;

    @Override
    public List<MetroStation> getAllMetroStations() {
        return metroStationRepository.findAll();
    }

    @Override
    public MetroStation getMetroStationById(Long id) {
        return metroStationRepository.findById(id).orElse(null);
    }

    @Override
    public MetroStation createMetroStation(MetroStation metroStation) {
        // Additional validation or business logic can be added here
        return metroStationRepository.save(metroStation);
    }

    @Override
    public MetroStation updateMetroStation(Long id, MetroStation metroStation) {
        // Additional validation or business logic can be added here
        metroStation.setId(id);
        return metroStationRepository.save(metroStation);
    }

    @Override
    public void deleteMetroStation(Long id) {
        metroStationRepository.deleteById(id);
    }
}