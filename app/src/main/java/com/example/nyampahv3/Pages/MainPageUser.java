package com.example.nyampahv3.Pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nyampahv3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPageUser extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_v3_user);
    }
}