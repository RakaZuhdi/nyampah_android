package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainPageUser extends AppCompatActivity {

    private CardView card_gopay_mainPageUser;
    private CardView card_ovo_mainPageUser;
    private CardView card_bca_mainPageUser;
    private CardView card_bsi_mainPageUser;
    private CardView card_dana_mainPageUser;
    private CardView card_linkaja_mainPageUser;
    private NavigationView navigationView;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);

        navigationView = findViewById(R.id.nav_view_mainpage);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                if(item.getItemId() == R.id.nav_home){
                    openHomePage();
                }

                if(item.getItemId() == R.id.nav_profile){
                    openProfilePage();
                }

                if(item.getItemId() == R.id.nav_request){
                    openTrashPage();
                }

                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        card_gopay_mainPageUser = (CardView) findViewById(R.id.cardview_gopay);
        card_gopay_mainPageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRedeemPageUser("GOPAY");
            }
        });

        card_ovo_mainPageUser = (CardView) findViewById(R.id.cardview_ovo);
        card_ovo_mainPageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRedeemPageUser("OVO");
            }
        });

        card_bca_mainPageUser = (CardView) findViewById(R.id.cardview_bca);
        card_bca_mainPageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRedeemPageUser("BCA");
            }
        });

        card_bsi_mainPageUser = (CardView) findViewById(R.id.cardview_bsi);
        card_bsi_mainPageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRedeemPageUser("BSI");
            }
        });

        card_dana_mainPageUser = (CardView) findViewById(R.id.cardview_dana);
        card_dana_mainPageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRedeemPageUser("DANA");
            }
        });

        card_linkaja_mainPageUser = (CardView) findViewById(R.id.cardview_linkaja);
        card_linkaja_mainPageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRedeemPageUser("LINK AJA");
            }
        });
    }

    public void openRedeemPageUser(String redeemType){
        Intent intent = new Intent(this, RedeemPage.class);
        intent.putExtra("redeemType", redeemType);
        startActivity(intent);
    }

    public void openProfilePage(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

    public void openTrashPage(){
        Intent intent = new Intent(this, TrashPickupLocationUser.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }


}