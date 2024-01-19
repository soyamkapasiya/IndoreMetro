package com.kapasiya.indoremetro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private MetroStation station;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private MetroRoute route;

    public UserPreference()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MetroStation getFavoriteStation() {
        return station;
    }

    public void setFavoriteStation(MetroStation station) {
        this.station = station;
    }

    public MetroRoute getFavoriteRoute()
    {
        return route;
    }

    public void setFavoriteRoute(MetroRoute route) {
        this.route = route;
    }

    public UserPreference(User user, MetroStation station, MetroRoute route)
    {
        this.user = user;
        this.station = station;
        this.route = route;
    }
}
