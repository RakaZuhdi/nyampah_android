package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class TrashPickupLocationUser extends AppCompatActivity {

    private NavigationView navigationView;
    private Button buttonSetPickupPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_user_pickup_trash_activity);

        buttonSetPickupPoint = (Button) findViewById(R.id.trash_pickup_uploadphoto_button);
        buttonSetPickupPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrashPickupPhotoPage();
            }
        });

        navigationView = findViewById(R.id.nav_view_trash_pickup_location);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                if(item.getItemId() == R.id.nav_home){
                    openHomePage();
                }

                if(item.getItemId() == R.id.nav_request){
                    openTrashPage();
                }

                if(item.getItemId() == R.id.nav_profile){
                    openProfilePage();
                }

                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    public void openHomePage(){
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }

    public void openTrashPage(){
        Intent intent = new Intent(this, TrashPickupLocationUser.class);
        startActivity(intent);
    }

    public void openProfilePage(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

    public void openTrashPickupPhotoPage(){
        Intent intent = new Intent(this, TrashPickupPhotoUser.class);
        startActivity(intent);
    }
}