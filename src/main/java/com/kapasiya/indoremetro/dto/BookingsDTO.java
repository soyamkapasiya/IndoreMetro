package com.kapasiya.indoremetro.dto;

public class BookingsDTO {

    private int id;

    private String ticketID;

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    private String filterDate;

    private String toDestination;

    private String fromDestination;

    private Double price;

    public String getMetroName() {
        return metroName;
    }

    public void setMetroName(String metroName) {
        this.metroName = metroName;
    }

    private String metroName;

    private String time;

    private int noOfPersons ;

    private Double totalCalculated ;

    private String tripStatus;

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


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }

    public Double getTotalCalculated() {
        return totalCalculated;
    }

    public void setTotalCalculated(Double totalCalculated) {
        this.totalCalculated = totalCalculated;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookingsDTO{" +
                "id=" + id +
                ", ticketID='" + ticketID + '\'' +
                ", filterDate='" + filterDate + '\'' +
                ", toDestination='" + toDestination + '\'' +
                ", fromDestination='" + fromDestination + '\'' +
                ", price=" + price +
                ", MetroName='" + metroName + '\'' +
                ", time='" + time + '\'' +
                ", noOfPersons=" + noOfPersons +
                ", totalCalculated=" + totalCalculated +
                ", tripStatus='" + tripStatus + '\'' +
                '}';
    }
}
