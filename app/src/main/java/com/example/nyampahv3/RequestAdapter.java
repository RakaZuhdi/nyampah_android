package com.example.nyampahv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder> {
    private ArrayList<Request> requestsList;

    public RequestAdapter(ArrayList<Request> requestsList){
        this.requestsList = requestsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private Button requestButton;

        public MyViewHolder(final View view){
            super(view);

            requestButton = view.findViewById(R.id.list_item_request_button);
        }
    }



    @NonNull
    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapter.MyViewHolder holder, int position) {
        String name = requestsList.get(position).getUsername();
        holder.requestButton.setText("Request by " + name);
    }

    @Override
    public int getItemCount() {
        return requestsList.size();
    }
}
