package com.example.nyampahv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RedeemAdapter extends RecyclerView.Adapter<RedeemAdapter.MyViewHolder> {
    private ArrayList<Redeem> redeemList;

    public RedeemAdapter(ArrayList<Redeem> redeemList){
        this.redeemList = redeemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private Button redeemButton;

        public MyViewHolder(final View view){
            super(view);

            redeemButton = view.findViewById(R.id.list_item_redeem_button);
        }
    }



    @NonNull
    @Override
    public RedeemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.redeem_list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemAdapter.MyViewHolder holder, int position) {
        String name = redeemList.get(position).getUsername();
        holder.redeemButton.setText("Redeem " + name + " points");
    }

    @Override
    public int getItemCount() {
        return redeemList.size();
    }
}
