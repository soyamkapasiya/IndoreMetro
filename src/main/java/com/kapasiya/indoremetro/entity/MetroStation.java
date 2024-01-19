package com.kapasiya.indoremetro.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "metro_stations")
public class
MetroStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String stationName;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private MetroRoute route;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private boolean isActive = true;

    public MetroStation()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public MetroRoute getRoute() {
        return route;
    }

    public void setRoute(MetroRoute route) {
        this.route = route;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public MetroStation( String stationName, MetroRoute route, double latitude, double longitude, boolean isActive)
    {
        this.stationName = stationName;
        this.route = route;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isActive = isActive;
    }
}
