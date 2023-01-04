package com.example.nyampahv3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.nyampahv3.model.User;
import com.example.nyampahv3.util.SystemUtil;
import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.util.Date;

public class ProfilePage extends AppCompatActivity {

    private NavigationView navigationView;
    private Button logoutButton;
    private TextView text_fullname;
    private TextView text_email;
    private TextView text_total_trash;
    private TextView text_total_pickups;
    private TextView text_member_since;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_profile_activity);
        User user = SystemUtil.getCurrentLoggedInUserDataSharedPref();

        text_fullname = (TextView) findViewById(R.id.text_fullname_profile);
        text_fullname.setText(user.fullname);
        text_email = (TextView) findViewById(R.id.text_email_profile);
        text_email.setText(user.email);
        text_total_trash = (TextView) findViewById(R.id.text_totaltrash_profile);
        text_total_trash.setText(user.total_trash_weight + "KG");
        text_total_pickups = (TextView) findViewById(R.id.text_totalpickups_profile);
        text_total_trash.setText("");
        text_member_since = (TextView) findViewById(R.id.text_membersince_profile);
        text_member_since.setText(String.valueOf(user.created_at));
        text_total_pickups = (TextView) findViewById(R.id.text_totaltrash_profile);
        text_total_pickups.setText(String.valueOf(user.total_pickedup_trash));
        Date date = new Date(String.valueOf(user.created_at));
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        text_member_since.setText("Member since " + dateFormat.format(date));

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

                if(item.getItemId() == R.id.nav_request_user){
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