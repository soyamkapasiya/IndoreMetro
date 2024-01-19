package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.RealTimeUpdate;
import com.kapasiya.indoremetro.repo.RealTimeUpdateRepository;
import com.kapasiya.indoremetro.servicedefinitation.RealTimeUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealTimeUpdateServiceImpl implements RealTimeUpdateService {

    @Autowired
    private RealTimeUpdateRepository realTimeUpdateRepository;

    @Override
    public List<RealTimeUpdate> getAllRealTimeUpdates() {
        return realTimeUpdateRepository.findAll();
    }

    @Override
    public RealTimeUpdate getRealTimeUpdateById(Long id) {
        return realTimeUpdateRepository.findById(id).orElse(null);
    }

    @Override
    public RealTimeUpdate createRealTimeUpdate(RealTimeUpdate realTimeUpdate) {
        // Additional validation or business logic can be added here
        return realTimeUpdateRepository.save(realTimeUpdate);
    }

    @Override
    public RealTimeUpdate updateRealTimeUpdate(Long id, RealTimeUpdate realTimeUpdate) {
        // Additional validation or business logic can be added here
        realTimeUpdate.setId(id);
        return realTimeUpdateRepository.save(realTimeUpdate);
    }

    @Override
    public void deleteRealTimeUpdate(Long id) {
        realTimeUpdateRepository.deleteById(id);
    }
}