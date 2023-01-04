package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TrashRequestThankYouDriver extends AppCompatActivity {
    private Button backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trash_request_thankyou_driver);

        backToHome = (Button) findViewById(R.id.trash_pickup_backtohome_button_driver);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });
    }

    private void openHomePage() {
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }


}