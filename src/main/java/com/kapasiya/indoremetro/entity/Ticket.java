package com.kapasiya.indoremetro.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private MetroRoute route;

    @ManyToOne
    @JoinColumn(name = "source_station_id")
    private MetroStation sourceStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private MetroStation destinationStation;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private String status;

    // Constructors, getters, and setters...

    // Constructors
    public Ticket() {
        // Default constructor
    }

    public Ticket(User user, MetroRoute route, MetroStation sourceStation, MetroStation destinationStation, String issueDate, String departureTime, String arrivalTime, BigDecimal price, String status) {
        this.user = user;
        this.route = route;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.issueDate = issueDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.status = status;
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

    public MetroRoute getRoute() {
        return route;
    }

    public void setRoute(MetroRoute route) {
        this.route = route;
    }

    public MetroStation getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(MetroStation sourceStation) {
        this.sourceStation = sourceStation;
    }

    public MetroStation getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(MetroStation destinationStation) {
        this.destinationStation = destinationStation;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
