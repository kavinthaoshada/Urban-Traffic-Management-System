package com.assignment.bcd.servlet;

import com.assignment.bcd.remote.IOTData;
import jakarta.jms.TextMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "IOTDataManager", value = "/data-view")
public class IOTDataManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            InitialContext context = new InitialContext();
            IOTData iotData = (IOTData) context.lookup("api/v1/impl/IOTDataBean");
            List<JSONObject> iotDataList = iotData.getIOTDataList();

//                for(JSONObject listitem : iotDataList){
//                    resp.getWriter().write(listitem.toString(4));
//                    System.out.println(listitem.toString(4));
//                }

            JSONArray jsonArray = new JSONArray(iotDataList);
            resp.getWriter().write(jsonArray.toString(4));

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
