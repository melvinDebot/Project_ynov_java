package com.example.back.Services;

import com.example.back.Repository.AirplaneRepository;
import com.example.back.Repository.FlightRepository;
import com.example.back.models.Airplane;
import com.example.back.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public void insertAllFlight(Iterable<Flight> flights){
        flightRepository.saveAll(flights);
    }

}
