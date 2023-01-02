package com.example.nyampahv3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TrashPickupPhotoUser extends AppCompatActivity {

    private Button buttonSubmitPhoto;
    private Button buttonTakePhoto;
    private ImageView capturedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trash_pickup_photo_user);

        buttonSubmitPhoto = (Button) findViewById(R.id.trash_pickup_photosubmit_button);
        buttonSubmitPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrashPickupThankYouPage();
            }
        });

        capturedImage = (ImageView) findViewById(R.id.trash_pickup_capturedphoto_imageview);
        buttonTakePhoto = (Button) findViewById(R.id.trash_pickup_uploadphoto_button);

        buttonTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });


    }

    public void openTrashPickupThankYouPage(){
        Intent intent = new Intent(this, TrashPickupThankYouUser.class);
        startActivity(intent);
    }

    public void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(),"Captured",Toast.LENGTH_SHORT).show();
            Bitmap b = (Bitmap) data.getExtras().get("data");
            capturedImage.setImageBitmap(b);
        }
    }
}