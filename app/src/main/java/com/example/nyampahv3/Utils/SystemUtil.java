package com.example.nyampahv3.Utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.R;

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

    public static String getCurrentLoggedInUserData(Context ctx){
        SharedPreferences sp1= ctx.getSharedPreferences("login", MODE_PRIVATE);

        return sp1.getString("user_data", null);
    }

    public static boolean LoggedIn(Context ctx){
        return getCurrentLoggedInUserData(ctx) != null;
    }
}
