package com.example.nyampahv3.Pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nyampahv3.R;
import com.example.nyampahv3.Utils.SystemUtil;
import com.example.nyampahv3.databinding.MainPageBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNav extends AppCompatActivity {

    private static BottomNav instance;
    private int choice;
    private Context ctx;
    private MainPageBinding binding;


    private BottomNav(Context ctx){
        this.ctx = ctx;
        setListener();
    }

    public static BottomNav GetInstance(Context ctx){
        if(instance == null) instance = new BottomNav(ctx);

        return instance;
    }


    public void setListener(){

//        BottomNavigationView bnav = Activity.findViewById(R.id.bottomNavigationView);
//        bnav.setId(choice);
//
//        bnav.setOnItemSelectedListener(item -> {
//            int id = item.getItemId();
//            choice = id;
//
//            switch (id){
//                case R.id.bottom_nav_home:
//                    if(ctx.getClass().getSimpleName().equals(MainPage.class.getSimpleName())) return true;
//                    ctx.startActivity(new Intent(ctx.getApplicationContext(), MainPage.class));
//
//
//                case R.id.bottom_nav_photrash:
//                    //if(this.getClass().getSimpleName() == MainPage.class.getSimpleName()) return true;
//                    //startActivity(new Intent(getApplicationContext(),PhotoTrash.class));
//                    return true;
//
//                case R.id.bottom_nav_account:
//                    if(ctx.getClass().getSimpleName().equals(LoginPage.class.getSimpleName()))return true;
//
//                    if(SystemUtil.LoggedIn(ctx)) ctx.startActivity(new Intent(ctx.getApplicationContext(),ProfilePage.class));
//                    else ctx.startActivity(new Intent(ctx.getApplicationContext(),LoginPage.class));
//
//                    return true;
//
//            }
//
//            return false;
//        });
    }
}
