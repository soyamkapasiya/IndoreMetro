package com.kapasiya.indoremetro.controller;

import com.kapasiya.indoremetro.entity.MetroStation;
import com.kapasiya.indoremetro.servicedefinitation.MetroStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metro-stations")
public class MetroStationController {

    @Autowired
    private MetroStationService metroStationService;

    @GetMapping
    public List<MetroStation> getAllMetroStations()
    {
        return metroStationService.getAllMetroStations();
    }

    @GetMapping("/{id}")
    public MetroStation getMetroStationById(@PathVariable Long id) {
        return metroStationService.getMetroStationById(id);
    }

    @PostMapping
    public MetroStation createMetroStation(@RequestBody MetroStation metroStation) {
        return metroStationService.createMetroStation(metroStation);
    }

    @PutMapping("/{id}")
    public MetroStation updateMetroStation(@PathVariable Long id, @RequestBody MetroStation metroStation) {
        return metroStationService.updateMetroStation(id, metroStation);
    }

    @DeleteMapping("/{id}")
    public void deleteMetroStation(@PathVariable Long id) {
        metroStationService.deleteMetroStation(id);
    }
}
