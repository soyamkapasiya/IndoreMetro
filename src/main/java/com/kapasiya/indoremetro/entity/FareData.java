package com.kapasiya.indoremetro.entity;

import jakarta.persistence.*;

@Entity
@Table
public class FareData
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int source;

    private int destination;

    private double distance;


}
