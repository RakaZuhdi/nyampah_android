package com.example.nyampahv3.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.nyampahv3.R;
import com.example.nyampahv3.Utils.App;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        App.setActivity(this);
    }
}