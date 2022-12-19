package com.example.nyampahv3.Utils;

import android.content.Context;
import android.content.SharedPreferences;

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
}
