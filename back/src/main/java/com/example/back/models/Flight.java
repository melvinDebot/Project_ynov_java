package com.example.back.models;

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

    @Override
    public String toString() {
        return "Flight{" +
                "hex='" + hex + '\'' +
                ", flightNumber=" + flightNumber +
                ", status='" + status + '\'' +
                ", icao24='" + icao24 + '\'' +
                '}';
    }
}
