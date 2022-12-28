package com.example.nyampahv3.Pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyampahv3.R;

import java.util.ArrayList;

public class RedeemPage extends AppCompatActivity {
    private ArrayList<Redeem> redeemList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redeem_list_user);
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
        redeemList.add(new Redeem("Raka"));
        redeemList.add(new Redeem("Ferdi"));
        redeemList.add(new Redeem("Daniel"));
        redeemList.add(new Redeem("Dyon"));
        redeemList.add(new Redeem("Diva"));
        redeemList.add(new Redeem("Bayu"));
        redeemList.add(new Redeem("Arkent"));
        redeemList.add(new Redeem("Dave"));
        redeemList.add(new Redeem("Micha"));

    }
}