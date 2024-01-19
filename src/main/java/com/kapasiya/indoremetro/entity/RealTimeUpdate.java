package com.kapasiya.indoremetro.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "real_time_updates")
public class RealTimeUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private MetroStation station;

    @Column(nullable = false)
    private String updateText;

    @Column(nullable = false)
    private String updateTime;

    public RealTimeUpdate(MetroStation station, String updateText, String updateTime)
    {
        this.station = station;
        this.updateText = updateText;
        this.updateTime = updateTime;
    }

    public RealTimeUpdate()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetroStation getStation() {
        return station;
    }

    public void setStation(MetroStation station) {
        this.station = station;
    }

    public String getUpdateText() {
        return updateText;
    }

    public void setUpdateText(String updateText) {
        this.updateText = updateText;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
