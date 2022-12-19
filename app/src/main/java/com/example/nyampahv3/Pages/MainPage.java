package com.example.nyampahv3.Pages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.R;
import com.example.nyampahv3.R.id;
import com.example.nyampahv3.Utils.ApiUtil;
import com.example.nyampahv3.Utils.SystemUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainPage extends AppCompatActivity {

    Gson gson = new Gson();

    TextView poinText;
    TextView trashDeposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        BottomNavigationView bnav = (BottomNavigationView) findViewById(id.bottomNavigationView);

        poinText = findViewById(id.text_numerical_points);
        trashDeposit = findViewById(id.text_numerical_trash_deposited);

        SharedPreferences sp1=this.getSharedPreferences("login", MODE_PRIVATE);

        User currentUser = null;
        String user_data =sp1.getString("user_data", null);

        if(user_data == null) currentUser = User.defaultInstance();
        else currentUser = gson.fromJson(user_data, User.class);

        poinText.setText(currentUser.point+"");
        //trashDeposit.setText(currentUser.);


//        UserApi.getAll();




        ImageView dp = findViewById(id.imageView5);

        bnav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            switch (id){
                case R.id.bottom_nav_home:
                    if(this.getClass().getSimpleName().equals(MainPage.class.getSimpleName())) return true;
                    startActivity(new Intent(getApplicationContext(),MainPage.class));


                case R.id.bottom_nav_photrash:
                    //if(this.getClass().getSimpleName() == MainPage.class.getSimpleName()) return true;
                    //startActivity(new Intent(getApplicationContext(),PhotoTrash.class));
                    return true;

                case R.id.bottom_nav_account:
                    if(this.getClass().getSimpleName().equals(LoginPage.class.getSimpleName())) return true;
                    startActivity(new Intent(getApplicationContext(),LoginPage.class));
                    return true;

            }

            return false;
        });
    }
}