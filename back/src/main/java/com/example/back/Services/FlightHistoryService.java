package com.example.back.Services;

import com.example.back.Repository.FlightHistoryRepository;
import com.example.back.Repository.FlightRepository;
import com.example.back.models.Airplane;
import com.example.back.models.Flight;
import com.example.back.models.FlightHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightHistoryService {
    FlightHistoryRepository flightHistoryRepository;

    @Autowired
    public FlightHistoryService(FlightHistoryRepository flightHistoryRepository) {
        this.flightHistoryRepository = flightHistoryRepository;
    }

    public void insertAllFlightHistory(Iterable<FlightHistory> flightHistory) {
        flightHistoryRepository.saveAll(flightHistory);
    }

}
