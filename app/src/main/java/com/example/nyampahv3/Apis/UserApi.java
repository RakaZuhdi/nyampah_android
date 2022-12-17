package com.example.nyampahv3.Apis;

import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.Utils.ApiUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class UserApi {

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



}
