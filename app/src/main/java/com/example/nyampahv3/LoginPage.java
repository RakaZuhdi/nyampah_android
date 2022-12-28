package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    private Button button_submit_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        button_submit_login = (Button) findViewById(R.id.button_submit_login);
        button_submit_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });
    }

    public void openMainPage(){
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }
}