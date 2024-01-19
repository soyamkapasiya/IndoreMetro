package com.kapasiya.indoremetro.servicedefinitation;

import com.kapasiya.indoremetro.entity.RealTimeUpdate;

import java.util.List;

public interface RealTimeUpdateService {
    List<RealTimeUpdate> getAllRealTimeUpdates();
    RealTimeUpdate getRealTimeUpdateById(Long id);
    RealTimeUpdate createRealTimeUpdate(RealTimeUpdate realTimeUpdate);
    RealTimeUpdate updateRealTimeUpdate(Long id, RealTimeUpdate realTimeUpdate);
    void deleteRealTimeUpdate(Long id);
}