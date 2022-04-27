package com.example.apiflight.controllers;

import com.example.apiflight.Services.FlightHistoryService;
import com.example.apiflight.Services.FlightService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class FlightHistoryController {

    @Autowired
    FlightHistoryService flightHistoryService;

    @Autowired
    public FlightHistoryController(FlightHistoryService flightHistoryService) {
        this.flightHistoryService = flightHistoryService;
    }

    @RequestMapping(path = "/history")
    public String getFlight() {
        JSONArray jsonArray = new JSONArray(flightHistoryService.getAllFlightsHistory());
        return jsonArray.toString();
    }

    @RequestMapping(path = "/history/{id}")
    public String getFlightById(@PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject(flightHistoryService.getFlightHistoryById(id));
        return jsonObject.toString();
    }
}
