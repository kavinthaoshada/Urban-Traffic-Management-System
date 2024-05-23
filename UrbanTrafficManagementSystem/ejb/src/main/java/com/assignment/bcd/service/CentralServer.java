package com.assignment.bcd.service;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CentralServer {
    private final static List<JSONObject> iotDataList = new ArrayList<>();

    public static void addIOTData(JSONObject jsonObject){
        int maximumDataStoreValue = 20;
        if(iotDataList.size()<maximumDataStoreValue){
            iotDataList.add(jsonObject);
//            System.out.println(iotDataList.size());
        }else{
            iotDataList.remove(0);
            iotDataList.add(jsonObject);
//            System.out.println(iotDataList.size());
        }

    }
    public static List<JSONObject> getIOTDataList(){
        return iotDataList;
    }
}
