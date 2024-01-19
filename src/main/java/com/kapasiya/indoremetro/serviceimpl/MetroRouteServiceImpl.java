package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.MetroRoute;
import com.kapasiya.indoremetro.repo.MetroRouteRepository;
import com.kapasiya.indoremetro.servicedefinitation.MetroRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetroRouteServiceImpl implements MetroRouteService {

    @Autowired
    private MetroRouteRepository metroRouteRepository;

    @Override
    public List<MetroRoute> getAllMetroRoutes() {
        return metroRouteRepository.findAll();
    }

    @Override
    public MetroRoute getMetroRouteById(Long id) {
        return metroRouteRepository.findById(id).orElse(null);
    }

    @Override
    public MetroRoute createMetroRoute(MetroRoute metroRoute) {
        // Additional validation or business logic can be added here
        return metroRouteRepository.save(metroRoute);
    }

    @Override
    public MetroRoute updateMetroRoute(Long id, MetroRoute metroRoute) {
        // Additional validation or business logic can be added here
        metroRoute.setId(id);
        return metroRouteRepository.save(metroRoute);
    }

    @Override
    public void deleteMetroRoute(Long id) {
        metroRouteRepository.deleteById(id);
    }
}