package com.kapasiya.indoremetro.servicedefinitation;

import com.kapasiya.indoremetro.entity.MetroRoute;

import java.util.List;

public interface MetroRouteService
{
    List<MetroRoute> getAllMetroRoutes();
    MetroRoute getMetroRouteById(Long id);
    MetroRoute createMetroRoute(MetroRoute metroRoute);
    MetroRoute updateMetroRoute(Long id, MetroRoute metroRoute);
    void deleteMetroRoute(Long id);
}
