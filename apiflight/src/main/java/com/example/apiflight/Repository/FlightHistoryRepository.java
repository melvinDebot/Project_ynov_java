package com.example.apiflight.Repository;

import com.example.apiflight.models.FlightHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightHistoryRepository extends JpaRepository<FlightHistory, String> {
}
