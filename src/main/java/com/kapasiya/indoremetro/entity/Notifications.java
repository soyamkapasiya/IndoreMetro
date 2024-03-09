package com.kapasiya.indoremetro.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "notification_details")
public class Notifications
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String date;

    private String heading;

    private String Description;

    public Notifications()
    {

    }
    public Notifications(int id, String date, String heading, String description) {
        this.id = id;
        this.date = date;
        this.heading = heading;
        Description = description;
    }

}
