package com.example.nyampahv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nyampahv3.api.UserApi;
import com.example.nyampahv3.model.User;
import com.example.nyampahv3.util.App;

public class LandingPage extends AppCompatActivity {

    private Button button_loginas;
    private Button button_register;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        App.setContext(getApplicationContext());

        button_loginas = (Button) findViewById(R.id.button_login_as_landingpage);
        button_loginas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });

        try {
            User result = UserApi.TokenLogin();
            Log.d("test", result.fullname);

            if(result.fullname != null){
                Intent intent = new Intent(this, MainPageUser.class);
                startActivity(intent);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        button_register = (Button) findViewById(R.id.button_register_landingpage);
        button_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openRegisterPage();
            }
        });
    }

    public void openLoginPage(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    public void openRegisterPage(){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
}