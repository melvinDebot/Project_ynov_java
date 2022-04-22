package com.example.apiflight.controllers;

import com.example.apiflight.Services.AirplaneService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @RequestMapping(path = "/airplanes")
    public String getAirplane() {
        JSONArray jsonArray = new JSONArray(airplaneService.getAllAirplanes());
        return jsonArray.toString();
    }

    @RequestMapping(path = "/airplanes/{id}")
    public String getAirplaneById(@PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject(airplaneService.getAirplaneById(id));
        return jsonObject.toString();
    }
}
