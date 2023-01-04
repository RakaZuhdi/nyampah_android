package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TrashRequestPickedUpDriver extends AppCompatActivity {
    private Button pickedUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trash_request_pickedup_driver);

        pickedUp = (Button) findViewById(R.id.trash_pickup_finish_button);
        pickedUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeightPage();
            }
        });
    }

    private void openWeightPage() {
        Intent intent = new Intent(this, TrashRequestWeightDriver.class);
        startActivity(intent);
    }

}