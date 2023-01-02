package com.example.nyampahv3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    private Button button_submit_login;
    private EditText input_password;
    private EditText input_email;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        input_password = findViewById(R.id.textInput_password);
        input_email = findViewById(R.id.textInput_email);

        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();


        button_submit_login = (Button) findViewById(R.id.button_submit_register);
        button_submit_login.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                if(input_email.getText().toString().equals("admin") && input_password.getText().toString().equals("password")){
                    Toast.makeText(getApplicationContext(),"Login successful!",Toast.LENGTH_SHORT).show();
                    openMainPage();
                }else{
                    Toast.makeText(getApplicationContext(),"Wrong credentials!",Toast.LENGTH_SHORT).show();
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