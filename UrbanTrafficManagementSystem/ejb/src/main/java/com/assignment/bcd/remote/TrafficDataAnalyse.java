package com.assignment.bcd.remote;

import jakarta.ejb.Remote;

import java.util.Map;

@Remote
public interface TrafficDataAnalyse {
        public double calculateAverageVehicleSpeed();

        public String identifyTrafficPatterns();

        public Map<String, Double> trafficFlowAnalysis();

        public double calculateUrbanMobilityEfficiency();
}
