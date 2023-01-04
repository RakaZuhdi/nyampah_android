package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TrashRequestWeightDriver extends AppCompatActivity {
    private Button buttonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trash_request_weight);

        buttonFinish = (Button) findViewById(R.id.trash_pickup_finish_button);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDriverThankYouPage();
            }
        });
    }

    private void openDriverThankYouPage() {
        Intent intent = new Intent(this, TrashRequestThankYouDriver.class);
        startActivity(intent);
    }
}