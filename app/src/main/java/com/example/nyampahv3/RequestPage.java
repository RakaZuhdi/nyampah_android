package com.example.nyampahv3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RequestPage extends AppCompatActivity {
    private ArrayList<Request> requestList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_list);
        recyclerView = findViewById(R.id.request_recyclerview_list);
        requestList = new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter(){
        RequestAdapter adapter = new RequestAdapter(requestList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        requestList.add(new Request("Raka"));
        requestList.add(new Request("Ferdi"));
        requestList.add(new Request("Daniel"));
        requestList.add(new Request("Dyon"));
        requestList.add(new Request("Diva"));
        requestList.add(new Request("Bayu"));
        requestList.add(new Request("Arkent"));
        requestList.add(new Request("Dave"));
        requestList.add(new Request("Micha"));

    }
}