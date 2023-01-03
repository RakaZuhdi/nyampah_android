package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterPage extends AppCompatActivity {

    private Button buttonRequestAnotherPickup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        buttonRequestAnotherPickup = (Button) findViewById(R.id.button_submit_register);
        buttonRequestAnotherPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Register successful!",Toast.LENGTH_SHORT).show();
                openLoginPage();
            }
        });

    }

    public void openLoginPage(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}