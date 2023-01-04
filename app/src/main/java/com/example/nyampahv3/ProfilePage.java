package com.example.nyampahv3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ProfilePage extends AppCompatActivity {

    private NavigationView navigationView;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_profile_activity);

        logoutButton = (Button) findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("login", 0);
                Log.d("Preferences", preferences.getString("user_data_json",""));
                preferences.edit().remove("user_data_json").commit();

                openHomePage();
            }
        });

        navigationView = findViewById(R.id.nav_view_profile);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                if(item.getItemId() == R.id.nav_home){
                    openHomePage();
                }

                if(item.getItemId() == R.id.nav_request){
                    openTrashPage();
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

    public void openLandingPage(){
        Intent intent = new Intent(this, LandingPage.class);
        startActivity(intent);
    }
}