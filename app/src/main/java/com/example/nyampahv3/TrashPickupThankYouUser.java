package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TrashPickupThankYouUser extends AppCompatActivity {

    private Button buttonRequestAnotherPickup;
    private Button buttonBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trash_pickup_thankyou_user);

        buttonRequestAnotherPickup = (Button) findViewById(R.id.trash_pickup_uploadphoto_button);
        buttonRequestAnotherPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrashPickupLocationPage();
            }
        });

        buttonBackToHome = (Button) findViewById(R.id.trash_pickup_backtohome_button);
        buttonBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });
    }

    public void openTrashPickupLocationPage(){
        Intent intent = new Intent(this, TrashPickupLocationUser.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }
}