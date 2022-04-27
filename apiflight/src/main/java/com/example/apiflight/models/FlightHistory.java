package com.example.apiflight.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "history")
public class FlightHistory {
    @Id
    private UUID id_history;
    private String date;
    private int speed;
    private int dir;
    private Float latitude;
    private Float longitude;
    private String flag;


    public FlightHistory(UUID id_history, String date, int speed, int dir, Float latitude, Float longitude, String flag) {
        this.id_history = id_history;
        this.date = date;
        this.speed = speed;
        this.dir = dir;
        this.latitude = latitude;
        this.longitude = longitude;
        this.flag = flag;
    }

    public FlightHistory() {
    }

    public UUID getId_history() {
        return id_history;
    }

    public void setId_history(UUID id_history) {
        this.id_history = id_history;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
