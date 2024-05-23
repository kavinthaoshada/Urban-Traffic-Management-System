package com.assignment.bcd.service;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticalServer {
    public double calculateAverageSpeed(List<JSONObject> jsonObjectList) {
        int totalSpeed = 0;
        int vehicleCount = 0;

        for (JSONObject jsonObject : jsonObjectList) {
            if (jsonObject.has("vehicle_speed")) {
                totalSpeed += jsonObject.getInt("vehicle_speed");
                vehicleCount++;
            }
        }

        if (vehicleCount == 0) {
            return 0;
        }

        return (double) totalSpeed / vehicleCount;
    }

    public String identifyTrafficPatterns(List<JSONObject> jsonObjectList) {
        double averageSpeed = calculateAverageSpeed(jsonObjectList);

        String pattern;
        if (averageSpeed < 20) {
            pattern = "Heavy traffic congestion detected.";
        } else if (averageSpeed >= 20 && averageSpeed < 50) {
            pattern = "Moderate traffic flow.";
        } else {
            pattern = "Smooth traffic flow.";
        }

        return pattern;
    }

    public Map<String, Double> performTrafficFlowAnalysis(List<JSONObject> jsonObjectList) {
        double averageSpeed = calculateAverageSpeed(jsonObjectList);

        int totalVehicles = jsonObjectList.size();

        int totalTime = jsonObjectList.size();
        double totalDistance = averageSpeed * totalTime;

        double trafficFlowRate = (double) totalVehicles / totalTime;

        double trafficDensity = (double) totalVehicles / totalDistance;
        trafficDensity = Double.parseDouble(String.format("%.4f", trafficDensity));

        Map<String, Double> trafficFlowData = new HashMap<String, Double>();
        trafficFlowData.put("Traffic Flow Rate", trafficFlowRate);
        trafficFlowData.put("Traffic Density", trafficDensity);

//        System.out.println("Traffic Flow Rate: " + trafficFlowRate + " vehicles/hour");
//        System.out.println("Traffic Density: " + trafficDensity + " vehicles/km");

        return trafficFlowData;
    }

    public double calculateUrbanMobilityEfficiency(List<JSONObject> jsonObjectList) {
        double trafficFlowRate = calculateTrafficFlowRate(jsonObjectList);
        double trafficDensity = calculateTrafficDensity(jsonObjectList);

        return trafficFlowRate / trafficDensity;
    }

    private double calculateTrafficFlowRate(List<JSONObject> jsonObjectList) {
        int totalVehicles = jsonObjectList.size();
        int totalTime = jsonObjectList.size();
        return (double) totalVehicles / totalTime;
    }

    private double calculateTrafficDensity(List<JSONObject> jsonObjectList) {
        double averageSpeed = calculateAverageSpeed(jsonObjectList);

        int totalVehicles = jsonObjectList.size();

        int totalTime = jsonObjectList.size();
        double totalDistance = averageSpeed * totalTime;

        return (double) totalVehicles / totalDistance;
    }
}

