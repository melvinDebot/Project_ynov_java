package com.example.apiflight.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plane")
public class Airplane {

    @Id
    @Column(name = "id_plane")
    private String icao24;
    private String label;

    public Airplane(String icao24, String label) {
        this.icao24 = icao24;
        this.label = label;
    }

    public Airplane() {

    }

    @Override
    public String toString() {
        return "Airplane{" +
                "icao24='" + icao24 + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
