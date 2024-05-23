package com.assignment.bcd.impl;

import com.assignment.bcd.remote.TrafficDataAnalyse;
import com.assignment.bcd.service.AnalyticalServer;
import com.assignment.bcd.service.CentralServer;
import jakarta.ejb.Stateless;

import java.util.Map;

@Stateless(mappedName = "api/v1/impl/TrafficDataAnalyseBean")
public class TrafficDataAnalyseBean implements TrafficDataAnalyse {
    private final AnalyticalServer analyticalServer = new AnalyticalServer();

    public double calculateAverageVehicleSpeed(){
        return analyticalServer.calculateAverageSpeed(CentralServer.getIOTDataList());
    }

    public String identifyTrafficPatterns(){
        return analyticalServer.identifyTrafficPatterns(CentralServer.getIOTDataList());
    }

    public Map<String, Double> trafficFlowAnalysis(){
        return analyticalServer.performTrafficFlowAnalysis(CentralServer.getIOTDataList());
    }

    public double calculateUrbanMobilityEfficiency(){
        return analyticalServer.calculateUrbanMobilityEfficiency(CentralServer.getIOTDataList());
    }
}
