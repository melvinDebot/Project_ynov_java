package com.example.back.Services;

import com.example.back.Repository.AirplaneRepository;
import com.example.back.models.Airplane;
import org.springframework.beans.factory.annotation.Autowired;

public class AirplaneService {
    AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository){
        this.airplaneRepository = airplaneRepository;
    }

    public void insertAirPlane(Airplane airplane){
        airplaneRepository.save(airplane);
    }
}
