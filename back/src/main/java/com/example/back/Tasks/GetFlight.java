package com.example.back.Tasks;

import com.example.back.Services.FlightService;
import com.example.back.models.Flight;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Component
public class GetFlight {

    @Autowired
    FlightService flightService;
    private static HttpURLConnection connection;

    @Scheduled(fixedDelay = 3600000)
    public void getFlight() {
        BufferedReader reader;
        String line;
        StringBuffer buffer = new StringBuffer();
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
                    buffer.append(line);
                }
                reader.close();

            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                reader.close();
            }
            parse(buffer.toString());
        } catch (ProtocolException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            connection.disconnect();
        }


    }

    public String parse(String response) {
        JSONObject jsonData = new JSONObject(response);
        JSONArray flights = new JSONArray(jsonData.getJSONArray("response"));

        for (int i = 0; i < flights.length(); i++) {
            JSONObject flight = flights.getJSONObject(i);
            String icao24 = getString(flight, "flight_icao", null);
            String hex = getString(flight, "hex", null);
            String flightNumber = getString(flight, "flight_number", null);
            String status = flight.getString("status");
            int speed = flight.getInt("speed");
            int dir = flight.getInt("dir");
            Float latitude = flight.getFloat("lat");
            Float longitude = flight.getFloat("lng");

            Flight flightObject = new Flight(hex, flightNumber, status, speed, dir, latitude, longitude, icao24);

            System.out.println(flightObject);
            flightService.insertFlight(flightObject);

        }
        return null;
    }

    public static Float getFloat(JSONArray plane, int index, Float defaultValue) { // au cas où un float est null
        try {
            return plane.getFloat(index);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String getString(JSONObject data, String key, String defaultValue) { // au cas où un string est null
        try {
            return data.getString(key);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
