package com.example.apiflight.controllers;

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
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(path = "/flights")
    public String getFlight() {
        JSONArray jsonArray = new JSONArray(flightService.getAllFlights());
        return jsonArray.toString();
    }

    @RequestMapping(path = "/flights/{id}")
    public String getFlightById(@PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject(flightService.getFlightById(id));
        return jsonObject.toString();
    }
}
