package com.example.veridic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "pricing")
    private String pricing;

    @Column(name = "address")
    private String address;


}