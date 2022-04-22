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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }
}
