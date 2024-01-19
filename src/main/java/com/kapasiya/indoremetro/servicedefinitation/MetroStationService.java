package com.kapasiya.indoremetro.servicedefinitation;

import com.kapasiya.indoremetro.entity.MetroStation;

import java.util.List;

public interface MetroStationService {
    List<MetroStation> getAllMetroStations();
    MetroStation getMetroStationById(Long id);
    MetroStation createMetroStation(MetroStation metroStation);
    MetroStation updateMetroStation(Long id, MetroStation metroStation);
    void deleteMetroStation(Long id);
}