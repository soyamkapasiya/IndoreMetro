package com.kapasiya.indoremetro.entity;


import jakarta.persistence.*;
@Entity
@Table(name = "metro_routes")
public class MetroRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String routeName;

    private String description;

    @Column(nullable = false)
    private boolean isActive = true;

    public MetroRoute()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public MetroRoute( String routeName, String description, boolean isActive)
    {
        this.routeName = routeName;
        this.description = description;
        this.isActive = isActive;
    }
}
