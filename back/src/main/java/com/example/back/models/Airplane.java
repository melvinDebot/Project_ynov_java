package com.example.back.models;

import javax.persistence.*;

@Entity
@Table(name = "plane")
public class Airplane {

    @Id
    @Column(name = "id_flight")
    private String hex;
    @Column(name = "id_plane")
    private String icao24;
    private String label;


    public Airplane(String icao24, String label, String hex) {
        this.icao24 = icao24;
        this.label = label;
        this.hex = hex;
    }

    public Airplane() {

    }

    @Override
    public String toString() {
        return "Airplane{" +
                "icao24='" + icao24 + '\'' +
                ", label='" + label + '\'' +
                ", hex='" + hex + '\'' +
                '}';
    }
}
