package com.example.nyampahv3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RedeemPage extends AppCompatActivity {
    private ArrayList<Redeem> redeemList;
    private RecyclerView recyclerView;
    private TextView textTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_trash_activity);


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
}