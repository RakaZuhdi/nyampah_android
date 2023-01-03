package com.example.nyampahv3.util;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.model.User;
import com.example.nyampahv3.R;
import com.example.nyampahv3.model.User;
import com.google.gson.Gson;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemUtil {
    public static boolean isInternetAvailable() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            return !address.equals("");
        } catch (UnknownHostException e) {
            // Log error
        }
        return false;
    }

    public static void writeSharedPreferenceString(SharedPreferences sharedPref, String name, String data){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(name, data);
        editor.apply();
    }

    public static void clearSharedPreference(String key){
        App.getContext().getSharedPreferences(key,0).edit().clear().commit();
    }

    public static User getCurrentLoggedInUserDataAPI(Context ctx) throws Exception {
        User u = UserApi.TokenLogin();

        return u;
    }

    public static User getCurrentLoggedInUserDataSharedPref(){
        SharedPreferences sp1= App.getContext().getSharedPreferences("login", MODE_PRIVATE);
        String data = sp1.getString("user_data", null);

        User currentUser = new Gson().fromJson(data, User.class);

        return currentUser;
    }

    public static boolean LoggedIn(){
        return getCurrentLoggedInUserDataSharedPref() != null;
    }

    public static String getCurrentUserBearerToken(){
        User x = getCurrentLoggedInUserDataSharedPref();

        if(x == null) return null;

        return x.token;

    }
}
