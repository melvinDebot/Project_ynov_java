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
    @Column(name = "id_flight")
    private String hex;

    public Airplane(String icao24, String label, String hex) {
        this.icao24 = icao24;
        this.label = label;
        this.hex = hex;
    }

    public Airplane() {

    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
