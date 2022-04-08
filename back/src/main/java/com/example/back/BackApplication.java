package com.example.back;

import org.apache.http.HttpStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackApplication {

    public static String BASE_URL = "https://airlabs.co/api/v9/flights?api_key=537a34ad-98f0-4616-adae-ec9a3f8e1da1";

    public static void main(String[] args) {

        SpringApplication.run(BackApplication.class, args);

    }

}
