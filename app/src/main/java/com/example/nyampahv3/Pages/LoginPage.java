package com.example.nyampahv3.Pages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.R;
import com.example.nyampahv3.Utils.AlertUtil;
import com.example.nyampahv3.Utils.App;
import com.example.nyampahv3.Utils.SystemUtil;
import com.google.gson.Gson;

public class LoginPage extends AppCompatActivity {

    EditText email;
    EditText password;
    TextView registerNowTxt;
    Button  loginBtn;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        App.setActivity(this);

        email = findViewById(R.id.textInput_email);
        password = findViewById(R.id.textInput_password);
        loginBtn = findViewById(R.id.button_submit);
        registerNowTxt = findViewById(R.id.registernow);

        SharedPreferences sp1=this.getSharedPreferences("login", MODE_PRIVATE);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    User login = UserApi.Login(email.getText().toString(), password.getText().toString());

                    if(login.token == null){
                        //AlertUtil.alert("Login error","No token");
                        //Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_LONG);
                        return;
                    }
                    else{
                        SystemUtil.writeSharedPreferenceString(sp1, "user_data", gson.toJson(login));

                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG);

                        startActivity(new Intent(getApplicationContext(),MainPage.class));
                        return;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        registerNowTxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterPage.class));
                return;
            }
        });



    }
}