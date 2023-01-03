package com.example.nyampahv3.api;

import com.example.nyampahv3.model.User;
import com.example.nyampahv3.model.trash_history;
import com.example.nyampahv3.util.ApiUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Type;


public class TrasHistoryApi {

    static Gson gson = new Gson();
    static Type type = trash_history.class;
    static Type lisType = trash_history[].class;

    public static trash_history SubmiTrash(trash_history u) throws Exception {

        trash_history th =  ApiUtil.POST("v1/submit_trash", null, gson.toJson(u) , type);

        return th;
    }

    public static JSONObject PickupTrash(int id, double weight) throws Exception {

        JSONObject body = new JSONObject();
        body.put("weight",weight);

        JSONObject th =  ApiUtil.POST("v1/pickup_trash/" + id, null, gson.toJson(body) , null);

        if(th.getString("success") != null){
            return th;
        }

        return null;
    }

    public static JSONObject FinishTrash(int id) throws Exception {


        JSONObject th =  ApiUtil.POST("v1/finish_trash/" + id, null, null , null);

        if(th.getString("success") != null){
            return th;
        }

        return null;
    }


    public static trash_history[] GetMyTrash_Customer() throws Exception {

        trash_history[] trashes = {};

        trashes =  ApiUtil.GET("v1/customer/my_trash", null, lisType);

        return trashes;

    }

    public static trash_history[] GetMyTrash_Driver() throws Exception {

        trash_history[] trashes = {};

        trashes =  ApiUtil.GET("v1/driver/my_trash", null, lisType);

        return trashes;

    }

    public static trash_history[] GetAvailable() throws Exception {

        trash_history[] trashes = {};

        trashes =  ApiUtil.GET("v1/trash_request/available", null, lisType);

        return trashes;

    }

}
