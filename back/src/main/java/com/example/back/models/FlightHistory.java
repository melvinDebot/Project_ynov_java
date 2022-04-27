package com.example.back.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "history")
public class FlightHistory {

    @Id
    @Column(name = "id_history",columnDefinition = "uniqueidentifier")
    private UUID idHistory;
    @Column(name = "id_flight")
    private String hex;
    private String date;
    private int speed;
    private int dir;
    private Float latitude;
    private Float longitude;
    private String flag;


    public FlightHistory(UUID idHistory, String hex, String date, int speed, int dir, Float latitude, Float longitude, String flag) {
        this.idHistory = idHistory;
        this.hex = hex;
        this.date = date;
        this.speed = speed;
        this.dir = dir;
        this.latitude = latitude;
        this.longitude = longitude;
        this.flag = flag;
    }

    public FlightHistory() {
    }

    @Override
    public String toString() {
        return "FlightHistory{" +
                "idHistory=" + idHistory +
                ", hex='" + hex + '\'' +
                ", date='" + date + '\'' +
                ", speed=" + speed +
                ", dir=" + dir +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", flag='" + flag + '\'' +
                '}';
    }
}
