package com.kapasiya.indoremetro.controller;

import com.kapasiya.indoremetro.entity.RealTimeUpdate;
import com.kapasiya.indoremetro.servicedefinitation.RealTimeUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real-time-updates")
public class RealTimeUpdateController {

    @Autowired
    private RealTimeUpdateService realTimeUpdateService;

    @GetMapping
    public List<RealTimeUpdate> getAllRealTimeUpdates() {
        return realTimeUpdateService.getAllRealTimeUpdates();
    }

    @GetMapping("/{id}")
    public RealTimeUpdate getRealTimeUpdateById(@PathVariable Long id) {
        return realTimeUpdateService.getRealTimeUpdateById(id);
    }

    @PostMapping
    public RealTimeUpdate createRealTimeUpdate(@RequestBody RealTimeUpdate realTimeUpdate) {
        return realTimeUpdateService.createRealTimeUpdate(realTimeUpdate);
    }

    @PutMapping("/{id}")
    public RealTimeUpdate updateRealTimeUpdate(@PathVariable Long id, @RequestBody RealTimeUpdate realTimeUpdate) {
        return realTimeUpdateService.updateRealTimeUpdate(id, realTimeUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteRealTimeUpdate(@PathVariable Long id) {
        realTimeUpdateService.deleteRealTimeUpdate(id);
    }
}
