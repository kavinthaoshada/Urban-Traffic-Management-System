package com.assignment.bcd.iot;

import java.util.Random;
import org.json.JSONObject;

public class IOTDevice {
    private int vehicleSpeed;
    private String trafficLightStatus;
    private double latitude;
    private double longitude;

    public IOTDevice() {
        vehicleSpeed = 0;
        trafficLightStatus = null;
        latitude = 0.0;
        longitude = 0.0;
    }

    public String captureData() {
        Random random = new Random();

        int status = random.nextInt(3);
        switch (status){
            case 0:
                trafficLightStatus = "green";
                vehicleSpeed = random.nextInt(101);
                break;
            case 1:
                trafficLightStatus = "yellow";
                vehicleSpeed = random.nextInt(21);
                break;
            case 2:
                trafficLightStatus = "red";
                vehicleSpeed = 0;
                break;
        }

        latitude = -90 + random.nextDouble() * 180;
        longitude = -180 + random.nextDouble() * 360;

        JSONObject json = new JSONObject();
        json.put("vehicle_speed", vehicleSpeed);
        json.put("traffic_light_status", trafficLightStatus);
        json.put("latitude", latitude);
        json.put("longitude", longitude);

        return json.toString();
    }
}

