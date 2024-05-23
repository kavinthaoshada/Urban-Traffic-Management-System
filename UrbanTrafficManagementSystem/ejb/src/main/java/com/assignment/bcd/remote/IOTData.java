package com.assignment.bcd.remote;

import jakarta.ejb.Remote;
import org.json.JSONObject;

import java.util.List;

@Remote
public interface IOTData {
    public void addIOTData(JSONObject jsonObject);
    public List<JSONObject> getIOTDataList();
}
