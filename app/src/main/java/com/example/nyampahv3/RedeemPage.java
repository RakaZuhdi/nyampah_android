package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyampahv3.util.App;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class RedeemPage extends AppCompatActivity {
    private ArrayList<Redeem> redeemList;
    private RecyclerView recyclerView;
    private TextView textTitle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_redeem_activity);
        App.setActivity(this);

        navigationView = findViewById(R.id.nav_view_redeem);
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

                return true;
            }
        });

        String redeemType = getIntent().getStringExtra("redeemType");
        redeemType ="Redeem " + redeemType + " Coupons";
        textTitle = (TextView) findViewById(R.id.text_redeempoints_redeem_list_user);
        textTitle.setText(redeemType);

        recyclerView = findViewById(R.id.redeem_recyclerview_list);
        redeemList = new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter(){
        RedeemAdapter adapter = new RedeemAdapter(redeemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        redeemList.add(new Redeem("60.000"));
        redeemList.add(new Redeem("120.000"));
        redeemList.add(new Redeem("180.000"));
        redeemList.add(new Redeem("240.000"));
        redeemList.add(new Redeem("300.000"));
        redeemList.add(new Redeem("360.000"));

    }

    public void openProfilePage(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(this, MainPageUser.class);
        startActivity(intent);
    }

    public void openTrashPage(){
        Intent intent = new Intent(this, TrashPickupLocationUser.class);
        startActivity(intent);
    }
}