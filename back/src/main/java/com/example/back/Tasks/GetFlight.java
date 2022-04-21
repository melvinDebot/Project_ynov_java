package com.example.back.Tasks;

import com.example.back.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;
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
    public void getFlight(){
        BufferedReader reader;
        String line;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL("https://airlabs.co/api/v9/flights?api_key=537a34ad-98f0-4616-adae-ec9a3f8e1da1");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
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

    public String parse(String response){
        JSONObject
    }
}
