package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginAsPage extends AppCompatActivity {
    private Button button_loginas_customer;
    private Button button_loginas_driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_as_page);

        button_loginas_customer = (Button) findViewById(R.id.button_customer_loginas);
        button_loginas_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });

        button_loginas_driver = (Button) findViewById(R.id.button_submit_login);
        button_loginas_driver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openLoginPage();
            }
        });
    }

    public void openLoginPage(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}