package com.example.nyampahv3.util;

import android.app.Activity;
import android.content.Context;

public class App {
    private static Context context;
    private static Activity activity;

    public static void setContext(Context cntxt) {
        context = cntxt;
    }
    public static void setActivity(Activity ac) {
        activity = ac;
    }

    public static Context getContext() {
        return context;
    }
    public static Activity getActivity() {
        return activity;
    }
}
