package com.assignment.bcd.impl;

import com.assignment.bcd.remote.IOTData;
import com.assignment.bcd.service.CentralServer;
import jakarta.ejb.Singleton;
import org.json.JSONObject;

import java.util.List;

@Singleton(mappedName = "api/v1/impl/IOTDataBean")
public class IOTDataBean implements IOTData {

    public void addIOTData(JSONObject jsonObject){
        CentralServer.addIOTData(jsonObject);
    }
    public List<JSONObject> getIOTDataList(){
        return CentralServer.getIOTDataList();
    }
}
