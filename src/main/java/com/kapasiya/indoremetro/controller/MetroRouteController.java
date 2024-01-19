package com.kapasiya.indoremetro.controller;

import com.kapasiya.indoremetro.entity.MetroRoute;
import com.kapasiya.indoremetro.servicedefinitation.MetroRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metro-routes")
public class MetroRouteController {

    @Autowired
    private MetroRouteService metroRouteService;


    @GetMapping
    public List<MetroRoute> getAllMetroRoutes()
    {
        return metroRouteService.getAllMetroRoutes();
    }

    @GetMapping("/{id}")
    public MetroRoute getMetroRouteById(@PathVariable Long id)
    {
        return metroRouteService.getMetroRouteById(id);
    }

    @PostMapping
    public MetroRoute createMetroRoute(@RequestBody MetroRoute metroRoute)
    {
        return metroRouteService.createMetroRoute(metroRoute);
    }

    @PutMapping("/{id}")
    public MetroRoute updateMetroRoute(@PathVariable Long id, @RequestBody MetroRoute metroRoute)
    {
        return metroRouteService.updateMetroRoute(id, metroRoute);
    }

    @DeleteMapping("/{id}")
    public void deleteMetroRoute(@PathVariable Long id)
    {
        metroRouteService.deleteMetroRoute(id);
    }
}
