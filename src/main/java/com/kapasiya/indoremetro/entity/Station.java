package com.kapasiya.indoremetro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "station_data")
public class Station
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int station_id;
    private String station_name;

    @Override
    public String toString() {
        return ("Station id: " + this.station_id + " Station Name: " + this.station_name);
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
}