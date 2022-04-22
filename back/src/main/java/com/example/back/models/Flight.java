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
    private int speed;
    private int dir;
    private Float latitude;
    private Float longitude;
    @Column(name = "id_plane")
    private String icao24;

    public Flight(String hex, String flightNumber, String status, int speed, int dir, Float latitude, Float longitude, String icao24) {
        this.hex = hex;
        this.flightNumber = flightNumber;
        this.status = status;
        this.speed = speed;
        this.dir = dir;
        this.latitude = latitude;
        this.longitude = longitude;
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
                ", speed=" + speed +
                ", dir=" + dir +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", icao24='" + icao24 + '\'' +
                '}';
    }
}