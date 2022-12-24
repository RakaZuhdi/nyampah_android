package com.example.nyampahv3.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorMessage {
    public String http_code;
    public String code;
    public String timestamp;
    public String error_message;

    public ErrorMessage(JSONObject e) throws JSONException {
        this.http_code = e.getString("http_code");
        this.code = e.getString("code");
        this.timestamp = e.getString("timestamp");
        this.error_message = e.getString("error_message");
    }
}
