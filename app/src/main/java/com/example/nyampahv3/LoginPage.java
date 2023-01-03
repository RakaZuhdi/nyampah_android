package com.example.nyampahv3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nyampahv3.api.UserApi;
import com.example.nyampahv3.model.User;
import com.example.nyampahv3.util.App;
import com.example.nyampahv3.util.SystemUtil;
import com.google.gson.Gson;

public class LoginPage extends AppCompatActivity {
    private Button button_submit_login;
    private EditText input_password;
    private EditText input_email;
    SharedPreferences sharedPreferences;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        App.setActivity(this);


        input_password = findViewById(R.id.textInput_password);
        input_email = findViewById(R.id.textInput_email);

        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();


        button_submit_login = (Button) findViewById(R.id.button_submit_register);
        button_submit_login.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                try {
                    User login = UserApi.Login(input_email.getText().toString(), input_password.getText().toString());

                    if(login.token == null){
                        //AlertUtil.alert("Login error","No token");
                        //Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_LONG);
                        return;
                    }
                    else{
                        sharedPreferences =getSharedPreferences("login",MODE_PRIVATE);
                        SystemUtil.writeSharedPreferenceString(sharedPreferences, "user_data", gson.toJson(login));

                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG);

                        openMainPage();
                        return;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void openMainPage(){
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }

    public void saveEmail(EditText text) {
        SharedPreferences sharedPref = getSharedPreferences("application", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("EMAIL", text.getText().toString());
        editor.apply();
    }
}