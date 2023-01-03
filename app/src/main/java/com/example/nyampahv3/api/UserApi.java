package com.example.nyampahv3.api;

import com.example.nyampahv3.model.User;
import com.example.nyampahv3.util.ApiUtil;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;


public class UserApi {

    static Gson gson = new Gson();
    static Type type = User.class;
    static Type lisType = User[].class;


    public static User[] GetAll() throws Exception {

        User[] users = {};

        users =  ApiUtil.GET("v1/users", null, lisType);

//        if(result == null) return new JSONArray(new ArrayList<String>());;
        if(users == null) return new User[0];

//        return result.toJSONArray(result.names());
        return users;

    }


    public static User Login(String email, String password) throws Exception {

        JSONObject credential  = new JSONObject();
        credential.put("email",email);
        credential.put("password",password);

        User user =  ApiUtil.POST("v1/user/login", null, credential.toString(), type);

        return user;
    }

    public static User TokenLogin() throws Exception {

        JSONObject credential  = new JSONObject();

        User user =  ApiUtil.POST("v1/user/token_login", null, credential.toString(), type);

        return user;
    }

    public static User Register(User u) throws Exception {

        User user =  ApiUtil.POST("v1/user", null, gson.toJson(u) , type);

        return user;
    }

    public static JSONObject RedeemPoint(int point) throws Exception {

        JSONObject body  = new JSONObject();
        body.put("points",point);

        JSONObject user =  ApiUtil.POST("v1/redeem/points ", null, body.toString(), null);

        if(user.getString("success") != null){
            body.put("points", user.getString("point"));
            return body;
        }

        return null;
    }

}
