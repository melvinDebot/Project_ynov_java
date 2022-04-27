package com.example.apiflight.Services;

import com.example.apiflight.Repository.FlightHistoryRepository;
import com.example.apiflight.models.FlightHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightHistoryService {
    FlightHistoryRepository flightHistoryRepository;

    @Autowired
    public FlightHistoryService(FlightHistoryRepository flightHistoryRepository){
        this.flightHistoryRepository = flightHistoryRepository;
    }

    public List<FlightHistory> getAllFlightsHistory(){
        return flightHistoryRepository.findAll();
    }

    public FlightHistory getFlightHistoryById(String id) {
        return flightHistoryRepository.findById(id).get();
    }
}
