package com.example.apiflight.models;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "id_flight")
    private String hex;
    @Column(name = "flight_number")
    private String flightNumber;
    private String status;
    @Column(name = "id_plane")
    private String icao24;

    public Flight(String hex, String flightNumber, String status, String icao24) {
        this.hex = hex;
        this.flightNumber = flightNumber;
        this.status = status;
        this.icao24 = icao24;
    }

    public Flight() {

    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }
}
