package com.example.back.Tasks;

import com.example.back.Services.AirplaneService;
import com.example.back.Services.FlightHistoryService;
import com.example.back.Services.FlightService;
import com.example.back.models.Airplane;
import com.example.back.models.Flight;
import com.example.back.models.FlightHistory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FlightTasks {

    @Autowired
    AirplaneService airplaneService;
    @Autowired
    FlightService flightService;
    @Autowired
    FlightHistoryService flightHistoryService;
    private static HttpURLConnection connection;

    @Scheduled(fixedDelay = 3600000)
    public void getFlightTasks() {
        BufferedReader reader;
        String line;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL("https://airlabs.co/api/v9/flights?api_key=537a34ad-98f0-4616-adae-ec9a3f8e1da1");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            int status = connection.getResponseCode();
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();

            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
            }
            parse(builder.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            connection.disconnect();
        }


    }

    public void parse(String response) {
        List<Airplane> airplaneList = new ArrayList<>();
        List<Flight> flightList = new ArrayList<>();
        List<FlightHistory> flightHistoryList = new ArrayList<>();
        JSONObject jsonData = new JSONObject(response);
        JSONArray flights = new JSONArray(jsonData.getJSONArray("response"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        LocalDate localDate = LocalDate.now();

        for (int i = 0; i < flights.length(); i++) {
            JSONObject flight = flights.getJSONObject(i);
            String icao24 = getString(flight, "flight_icao", flight.getString("hex"));
            String label = getString(flight, "reg_number", null);
            String hex = getString(flight, "hex", null);
            UUID idHistory = UUID.randomUUID();
            String date = dtf.format(localDate);
            int speed = flight.getInt("speed");
            int dir = flight.getInt("dir");
            Float latitude = flight.getFloat("lat");
            Float longitude = flight.getFloat("lng");
            String flag = getString(flight, "flag", null);
            String flightNumber = getString(flight, "flight_number", null);
            String status = flight.getString("status");


            Airplane airplaneObject = new Airplane(icao24, label, hex);
            airplaneList.add(airplaneObject);
            Flight flightObject = new Flight(hex, flightNumber, status, icao24);
            flightList.add(flightObject);
            FlightHistory flightHistoryObject = new FlightHistory(idHistory, hex, date, speed, dir, latitude, longitude, flag);
            flightHistoryList.add(flightHistoryObject);
        }

        LocalTime startNow = LocalTime.now();
        LocalTime endNow = LocalTime.now();
        System.out.println("Start insert to BDD at " + startNow);

        airplaneService.insertAllAirplane(airplaneList);
        System.out.println("Insert all airplane in " + (endNow.getMinute() - startNow.getMinute()) + "minutes" + (endNow.getSecond() - startNow.getSecond()) + "seconds");

        flightService.insertAllFlight(flightList);
        System.out.println("Insert all flight in " + (endNow.getMinute() - startNow.getMinute()) + "minutes" + (endNow.getSecond() - startNow.getSecond()) + "seconds");

        flightHistoryService.insertAllFlightHistory(flightHistoryList);
        System.out.println("Insert all flight history in " + (endNow.getMinute() - startNow.getMinute()) + "minutes" + (endNow.getSecond() - startNow.getSecond()) + "seconds");

        System.out.println("Ending Save" + endNow);
        System.out.println("This task spend : " + (endNow.getMinute() - startNow.getMinute()) + "minutes" + (endNow.getSecond() - startNow.getSecond()) + "seconds");


    }


    public static String getString(JSONObject data, String key, String defaultValue) { // au cas où un string est null
        try {
            return data.getString(key);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
