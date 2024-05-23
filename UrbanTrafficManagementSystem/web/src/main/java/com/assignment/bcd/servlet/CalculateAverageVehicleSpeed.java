package com.assignment.bcd.servlet;

import com.assignment.bcd.remote.IOTData;
import com.assignment.bcd.remote.TrafficDataAnalyse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CalculateAverageVehicleSpeed",value = "/average-speed")
public class CalculateAverageVehicleSpeed extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            InitialContext context = new InitialContext();
            TrafficDataAnalyse trafficDataAnalyse = (TrafficDataAnalyse)
                    context.lookup("api/v1/impl/TrafficDataAnalyseBean");
            double averageVehicleSpeed = trafficDataAnalyse.calculateAverageVehicleSpeed();
            resp.getWriter().write(Double.toString(averageVehicleSpeed));

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
