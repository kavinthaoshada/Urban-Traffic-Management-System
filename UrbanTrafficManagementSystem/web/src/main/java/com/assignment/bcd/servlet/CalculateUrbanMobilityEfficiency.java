package com.assignment.bcd.servlet;

import com.assignment.bcd.remote.TrafficDataAnalyse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CalculateUrbanMobilityEfficiency", value = "/urban-mobility-efficiency")
public class CalculateUrbanMobilityEfficiency extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            InitialContext context = new InitialContext();
            TrafficDataAnalyse trafficDataAnalyse = (TrafficDataAnalyse)
                    context.lookup("api/v1/impl/TrafficDataAnalyseBean");
            double urbanMobilityEfficiency = trafficDataAnalyse.calculateUrbanMobilityEfficiency();
            resp.getWriter().write(Double.toString(urbanMobilityEfficiency));

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
