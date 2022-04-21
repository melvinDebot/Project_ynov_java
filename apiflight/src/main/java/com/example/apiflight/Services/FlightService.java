package com.example.apiflight.Services;

import com.example.apiflight.Repository.FlightRepository;
import com.example.apiflight.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public void insertFlight(Flight flight){
        flightRepository.save(flight);
    }
}
