package com.example.nyampahv3.Utils;

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
}
