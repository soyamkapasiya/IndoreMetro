package com.kapasiya.indoremetro.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "Reservation")
public class MetroData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String filterDate;

    private String toDestination;

    private String fromDestination;

    private Double price;

    private String MetroName;

    private String time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFilterDate() {
        return filterDate;
    }

    public void setFilterDate(String filterDate) {
        this.filterDate = filterDate;
    }

    public String getToDestination() {
        return toDestination;
    }

    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public void setFromDestination(String fromDestination) {
        this.fromDestination = fromDestination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMetroName() {
        return MetroName;
    }

    public void setMetroName(String metroName) {
        MetroName = metroName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MetroData{" +
                "id=" + id +
                ", filterDate='" + filterDate + '\'' +
                ", toDestination='" + toDestination + '\'' +
                ", fromDestination='" + fromDestination + '\'' +
                ", price=" + price +
                ", MetroName='" + MetroName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
