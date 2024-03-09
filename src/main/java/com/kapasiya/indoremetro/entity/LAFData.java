package com.kapasiya.indoremetro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class LAFData
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String itemName;

    private String location;

    private String date;

    private String description;

    @Column(length = 10, unique = true)
    private String phoneNumber;

}
