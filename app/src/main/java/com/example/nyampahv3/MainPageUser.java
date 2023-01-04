package com.example.nyampahv3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.nyampahv3.api.UserApi;
import com.example.nyampahv3.model.User;
import com.example.nyampahv3.util.SystemUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class MainPageUser extends AppCompatActivity {

    private CardView card_gopay_mainPageUser;
    private CardView card_ovo_mainPageUser;
    private CardView card_bca_mainPageUser;
    private CardView card_bsi_mainPageUser;
    private CardView card_dana_mainPageUser;
    private CardView card_linkaja_mainPageUser;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    private TextView textView_name;
    private TextView textView_points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);

        Gson gson = new Gson();



        SharedPreferences sp = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        SharedPreferences spj = getSharedPreferences("login", Context.MODE_PRIVATE);

        User user = null;

        if(SystemUtil.LoggedIn()){
            user = SystemUtil.getCurrentLoggedInUserDataSharedPref();
            try {
                user = UserApi.TokenLogin();
                Menu nav_menu = navigationView.getMenu();

                if(user.type.equals(User.Type.CUSTOMER)){
                    nav_menu.findItem(R.id.nav_request_driver).setVisible(false);
                }

                if(user.type.equals(User.Type.DRIVER)){
                    nav_menu.findItem(R.id.nav_request_user).setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            openLandingPage();
            return;
        }

        navigationView = findViewById(R.id.nav_view_mainpage);

        textView_name = (TextView) findViewById(R.id.main_hello_text);
        textView_name.setText("Hi, " + user.fullname);

        textView_points = (TextView) findViewById(R.id.text_numerical_points);
        textView_points.setText(user.point+"");

        textView_points = (TextView) findViewById(R.id.text_numerical_trash_deposited);
        textView_points.setText(user.total_trash_weight+" KG");

        Log.d("Total trash weight", String.valueOf(user.total_trash_weight));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                if(item.getItemId() == R.id.nav_home){
                    openHomePage();
                }

                if(item.getItemId() == R.id.nav_profile){
                    openProfilePage();
                }

                if(item.getItemId() == R.id.nav_request_user){
                    openTrashPageUser();
                }

                if(item.getItemId() == R.id.nav_request_driver){
                    openTrashPageDriver();
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

    private void openTrashPageDriver() {
        Intent intent = new Intent(this, TrashRequestDriver.class);
        startActivity(intent);
    }

    private void openLandingPage() {
        Intent intent = new Intent(this, LandingPage.class);
        startActivity(intent);
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

    public void openTrashPageUser(){
        Intent intent = new Intent(this, TrashPickupLocationUser.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }


}