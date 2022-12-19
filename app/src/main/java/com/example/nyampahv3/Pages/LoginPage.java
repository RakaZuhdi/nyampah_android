package com.example.nyampahv3.Pages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.R;
import com.example.nyampahv3.Utils.SystemUtil;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.Map;

public class LoginPage extends AppCompatActivity {

    EditText email;
    EditText password;
    Button  loginBtn;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        email = findViewById(R.id.textInput_email);
        password = findViewById(R.id.textInput_password);
        loginBtn = findViewById(R.id.button_submit);

        SharedPreferences sp1=this.getSharedPreferences("login", MODE_PRIVATE);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    User login = UserApi.Login(email.getText().toString(), password.getText().toString());

                    if(login.token == null){
                        System.out.println("No token");
                        Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_LONG);
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



    }
}